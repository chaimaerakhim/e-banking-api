package com.chaimae.restapi.ebankingapi.services;

import com.chaimae.restapi.ebankingapi.beans.Agent;
import com.chaimae.restapi.ebankingapi.beans.Agence;
import com.chaimae.restapi.ebankingapi.beans.Agent;
import com.chaimae.restapi.ebankingapi.beans.Operation;

import java.util.List;

public interface IAgentService {


    List<Agent> getAllAgents();

    Agent getAgentByCin(String cin);

    boolean addAgent(Agent agent);

    void updateAgent(Agent agent);

    void deleteAgent(String cin);

    boolean AgentExists(String cin);


}