package com.chaimae.restapi.ebankingapi.controllers;

import com.chaimae.restapi.ebankingapi.beans.Compte;
import com.chaimae.restapi.ebankingapi.services.ICompteService;
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
@Path("/compte")
public class CompteController {
    private static final Logger logger = LoggerFactory.getLogger(CompteController.class);

    @Autowired
    private ICompteService CompteService;

    @GET
    @Path("/details")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompteDetails() {
        List<Compte> list = CompteService.getAllComptes();
        return Response.ok(list).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompteById(@PathParam("id") int id) {
        Compte Compte = CompteService.getCompteById(id);
        return Response.ok(Compte).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCompte(Compte Compte) {
        boolean isAdded = CompteService.addCompte(Compte);
        if (!isAdded) {
            logger.info("Compte already exits.");
            return Response.status(Response.Status.CONFLICT).build();
        }
        return Response.created(URI.create("compte/" + Compte.getId())).build();
    }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCompte(Compte Compte) {
        CompteService.updateCompte(Compte);
        return Response.ok(Compte).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCompte(@PathParam("id") int id) {
        CompteService.deleteCompte(id);
        return Response.noContent().build();
    }

}