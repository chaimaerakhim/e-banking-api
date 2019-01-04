package com.chaimae.restapi.ebankingapi;

import com.chaimae.restapi.ebankingapi.beans.Compte;
import com.chaimae.restapi.ebankingapi.controllers.*;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;


@Component
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {

        packages("com.chaimae.restapi.ebankingapi.controllers");
        register(ClientController.class);
        register(CompteController.class);
        register(OperationController.class);
        register(AdminController.class);
        register(AgentController.class);
        register(AgenceController.class);
    }
}
