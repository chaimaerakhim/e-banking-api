package com.chaimae.restapi.ebankingapi.controllers;

import com.chaimae.restapi.ebankingapi.beans.Operation;
import com.chaimae.restapi.ebankingapi.services.IOperationService;
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
@Path("/operation")
public class OperationController {
    private static final Logger logger = LoggerFactory.getLogger(OperationController.class);

    @Autowired
    private IOperationService OperationService;

    @GET
    @Path("/details")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOperationDetails() {
        List<Operation> list = OperationService.getAllOperations();
        return Response.ok(list).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOperationById(@PathParam("id") int id) {
        Operation Operation = OperationService.getOperationById(id);
        return Response.ok(Operation).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOperation(Operation Operation) {
        boolean isAdded = OperationService.addOperation(Operation);
        if (!isAdded) {
            logger.info("Operation already exits.");
            return Response.status(Response.Status.CONFLICT).build();
        }
        return Response.created(URI.create("operation/" + Operation.getId())).build();
    }

    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOperation(Operation Operation) {
        OperationService.updateOperation(Operation);
        return Response.ok(Operation).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteOperation(@PathParam("id") int id) {
        OperationService.deleteOperation(id);
        return Response.noContent().build();
    }

}
