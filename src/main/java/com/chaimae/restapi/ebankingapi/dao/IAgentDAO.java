package com.chaimae.restapi.ebankingapi.dao;



import com.chaimae.restapi.ebankingapi.beans.Agent;

import java.util.List;

public interface IAgentDAO {

    List<Agent> getAllAgents();

    Agent getAgentByCin(String cin);

    void addAgent(Agent agent);

    void updateAgent(Agent agent);

    void deleteAgent(String Cin);

    boolean AgentExists(String cin);
}
 