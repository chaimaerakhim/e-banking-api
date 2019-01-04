package com.chaimae.restapi.ebankingapi.implementations;

import com.chaimae.restapi.ebankingapi.beans.Agent;
import com.chaimae.restapi.ebankingapi.dao.IAgentDAO;
import com.chaimae.restapi.ebankingapi.services.IAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService implements IAgentService {

    @Autowired
    private IAgentDAO AgentDAO;

    @Override
    public List<Agent> getAllAgents(){
        return AgentDAO.getAllAgents();
    }

    @Override
    public Agent getAgentByCin(String cin) {
        Agent obj = AgentDAO.getAgentByCin(cin);
        return obj;
    }

/*    @Override
    public boolean addAgent(Agent agent) {

        AgentDAO.addAgent(agent);
            return true;
    }*/



    @Override
    public synchronized boolean addAgent(Agent Agent){
        if (AgentDAO.AgentExists(Agent.getCin())) {
            return false;
        } else {
            AgentDAO.addAgent(Agent);
            return true;
        }
    }

    @Override
    public void updateAgent(Agent Agent) {
        AgentDAO.updateAgent(Agent);
    }

    @Override
    public void deleteAgent(String cin) {
        AgentDAO.deleteAgent(cin);
    }


}
