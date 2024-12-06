package app.rest.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.ItemComponent;
import app.dto.ItemDTO;

@Component
@Path("/items")
public class ItemController {
    @Autowired
    private ItemComponent itemComponent;

    @POST
    @Path("/item_deets")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createItem(ItemDTO itemDTO) {
        ItemDTO createdItemDTO = itemComponent.createItem(itemDTO);
        return Response.status(Response.Status.CREATED).entity(createdItemDTO).build();
    }

    @GET
    @Path("/{itemID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItem(@PathParam("itemID") int itemID) {
        return itemComponent.getItem(itemID)
                .map(itemDTO -> Response.ok(itemDTO).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}