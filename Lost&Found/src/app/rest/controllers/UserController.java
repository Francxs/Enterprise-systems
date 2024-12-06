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

import app.components.UserComponent;
import app.dto.UserDTO;

@Component
@Path("/users")
public class UserController {
    @Autowired
    private UserComponent userComponent;

    @POST
    @Path("/user_deets")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UserDTO userDTO) {
        UserDTO createdUserDTO = userComponent.createUser(userDTO);
        return Response.status(Response.Status.CREATED).entity(createdUserDTO).build();
    }

    @GET
    @Path("/{IDNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("IDNumber") int IDNumber) {
        return userComponent.getUser(IDNumber)
                .map(userDTO -> Response.ok(userDTO).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}