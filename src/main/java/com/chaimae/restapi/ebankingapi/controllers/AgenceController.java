package com.chaimae.restapi.ebankingapi.controllers;

import com.chaimae.restapi.ebankingapi.beans.Agence;
import com.chaimae.restapi.ebankingapi.services.IAgenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/agence")
public class AgenceController {
    private static final Logger logger = LoggerFactory.getLogger(AgenceController.class);

    @Autowired
    private IAgenceService AgenceService;

    @GET
    @Path("/details")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAgenceDetails() {
        List<Agence> list = AgenceService.getAllAgences();
        return Response.ok(list).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAgenceById(@PathParam("id") int id) {
        Agence Agence = AgenceService.getAgenceById(id);
        return Response.ok(Agence).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAgence(Agence Agence) {
        boolean isAdded = AgenceService.addAgence(Agence);
        if (!isAdded) {
            logger.info("Agence already exits.");
            return Response.status(Response.Status.CONFLICT).build();
        }
        return Response.created(URI.create("agence/" + Agence.getId())).build();
    }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAgence(Agence Agence) {
        AgenceService.updateAgence(Agence);
        return Response.ok(Agence).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteAgence(@PathParam("id") int id) {
        AgenceService.deleteAgence(id);
        return Response.noContent().build();
    }
}