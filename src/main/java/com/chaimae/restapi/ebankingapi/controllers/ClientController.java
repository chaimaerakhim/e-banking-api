package com.chaimae.restapi.ebankingapi.controllers;


import com.chaimae.restapi.ebankingapi.beans.Client;
import com.chaimae.restapi.ebankingapi.services.IClientService;
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
@Path("/client")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private IClientService ClientService;

    @GET
    @Path("/details")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientDetails() {
        List<Client> list = ClientService.getAllClients();
        return Response.ok(list).build();
    }
    @GET
    @Path("/{cin}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientById(@PathParam("cin") String cin) {
        Client Client = ClientService.getClientByCin(cin);
        return Response.ok(Client).build();
    }
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addClient(Client Client) {
        boolean isAdded = ClientService.addClient(Client);
        if (!isAdded) {
            logger.info("Client already exits.");
            return Response.status(Response.Status.CONFLICT).build();
        }
        return Response.created(URI.create("client/"+ Client.getCin())).build();
    }
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateClient(Client Client) {
        ClientService.updateClient(Client);
        return Response.ok(Client).build();
    }
    @DELETE
    @Path("/{cin}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteClient(@PathParam("cin") String cin) {
        ClientService.deleteClient(cin);
        return Response.noContent().build();
    }
}
