package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.components.LocationComponent;
import app.dto.LocationDTO;

@Component
@Path("/locations")
public class LocationController {
    @Autowired
    private LocationComponent locationComponent;

    @POST
    @Path("/input")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createLocation(LocationDTO locationDTO) {
        LocationDTO createdLocationDTO = locationComponent.createLocation(locationDTO);
        return Response.status(Response.Status.CREATED).entity(createdLocationDTO).build();
    }

    @GET
    @Path("/{locationID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocation(@PathParam("locationID") int locationID) {
        return locationComponent.getLocation(locationID)
                .map(locationDTO -> Response.ok(locationDTO).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}
