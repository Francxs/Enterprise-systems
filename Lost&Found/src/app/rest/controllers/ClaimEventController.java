package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.ClaimEventComponent;
import app.dto.ClaimEventDTO;

@Component
@Path("/events")
public class ClaimEventController {
    @Autowired
    private ClaimEventComponent claimEventComponent;

    @POST
    @Path("/current")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createEvent(ClaimEventDTO eventDTO) {
        ClaimEventDTO createdEventDTO = claimEventComponent.createEvent(eventDTO);
        return Response.status(Response.Status.CREATED).entity(createdEventDTO).build();
    }

    @GET
    @Path("/{claimID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEvent(@PathParam("claimID") int claimID) {
        return claimEventComponent.getEvent(claimID)
                .map(eventDTO -> Response.ok(eventDTO).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}