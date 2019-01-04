package com.chaimae.restapi.ebankingapi.controllers;

import com.chaimae.restapi.ebankingapi.beans.Admin;
import com.chaimae.restapi.ebankingapi.services.IAdminService;
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
@Path("/admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(com.chaimae.restapi.ebankingapi.controllers.AdminController.class);

    @Autowired
    private IAdminService AdminService;

    @GET
    @Path("/details")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdminDetails() {
        List<Admin> list = AdminService.getAllAdmins();
        return Response.ok(list).build();
    }
    @GET
    @Path("/{cin}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdminById(@PathParam("cin") String cin) {
        Admin Admin = AdminService.getAdminByCin(cin);
        return Response.ok(Admin).build();
    }
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAdmin(Admin Admin) {
        boolean isAdded = AdminService.addAdmin(Admin);
        if (!isAdded) {
            logger.info("Admin already exits.");
            return Response.status(Response.Status.CONFLICT).build();
        }
        return Response.created(URI.create("admin/"+ Admin.getCin())).build();
    }
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAdmin(Admin Admin) {
        AdminService.updateAdmin(Admin);
        return Response.ok(Admin).build();
    }
    @DELETE
    @Path("/{cin}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteAdmin(@PathParam("cin") String cin) {
        AdminService.deleteAdmin(cin);
        return Response.noContent().build();
    }
}
