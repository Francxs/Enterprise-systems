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

import app.components.FoundReportComponent;
import app.dto.FoundReportDTO;

@Component
@Path("/reports")
public class FoundReportController {
    @Autowired
    private FoundReportComponent foundReportComponent;

    @POST
    @Path("/file")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createReport(FoundReportDTO reportDTO) {
        FoundReportDTO createdReportDTO = foundReportComponent.createReport(reportDTO);
        return Response.status(Response.Status.CREATED).entity(createdReportDTO).build();
    }

    @GET
    @Path("/{foundID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReport(@PathParam("foundID") int foundID) {
        return foundReportComponent.getReport(foundID)
                .map(reportDTO -> Response.ok(reportDTO).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}