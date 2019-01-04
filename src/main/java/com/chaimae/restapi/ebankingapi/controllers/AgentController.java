package com.chaimae.restapi.ebankingapi.controllers;

import com.chaimae.restapi.ebankingapi.beans.Agent;
import com.chaimae.restapi.ebankingapi.services.IAgentService;
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
@Path("/agent")
public class AgentController {

    private static final Logger logger = LoggerFactory.getLogger(com.chaimae.restapi.ebankingapi.controllers.AgentController.class);

    @Autowired
    private IAgentService AgentService;

    @GET
    @Path("/details")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAgentDetails() {
        List<Agent> list = AgentService.getAllAgents();
        return Response.ok(list).build();
    }
    @GET
    @Path("/{cin}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAgentById(@PathParam("cin") String cin) {
        Agent Agent = AgentService.getAgentByCin(cin);
        return Response.ok(Agent).build();
    }
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAgent(Agent Agent) {
        boolean isAdded = AgentService.addAgent(Agent);
        if (!isAdded) {
            logger.info("Agent already exits.");
            return Response.status(Response.Status.CONFLICT).build();
        }
        return Response.created(URI.create("agent/"+ Agent.getCin())).build();
    }
    @PUT
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAgent(Agent Agent) {
        AgentService.updateAgent(Agent);
        return Response.ok(Agent).build();
    }
    @DELETE
    @Path("/{cin}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteAgent(@PathParam("cin") String cin) {
        AgentService.deleteAgent(cin);
        return Response.noContent().build();
    }
}
