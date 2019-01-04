package com.chaimae.restapi.ebankingapi.implementations;

import com.chaimae.restapi.ebankingapi.beans.Agence;
import com.chaimae.restapi.ebankingapi.dao.IAgenceDAO;
import com.chaimae.restapi.ebankingapi.services.IAgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceService implements IAgenceService {

    @Autowired
    private IAgenceDAO AgenceDAO;

    @Override
    public List<Agence> getAllAgences(){
        return AgenceDAO.getAllAgences();
    }

    @Override
    public Agence getAgenceById(int id) {
        Agence obj = AgenceDAO.getAgenceById(id);
        return obj;
    }

    @Override
    public boolean addAgence(Agence agence) {

        AgenceDAO.addAgence(agence);
            return true;
    }



/*    @Override
    public synchronized boolean addAgence(Agence Agence){
        if (AgenceDAO.AgenceExists(Agence.getTitle(), Agence.getCategory())) {
            return false;
        } else {
            AgenceDAO.addAgence(Agence);
            return true;
        }
    }*/

    @Override
    public void updateAgence(Agence Agence) {
        AgenceDAO.updateAgence(Agence);
    }

    @Override
    public void deleteAgence(int id) {
        AgenceDAO.deleteAgence(id);
    }
}
