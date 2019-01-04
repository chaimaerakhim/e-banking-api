package com.chaimae.restapi.ebankingapi.dao;



import com.chaimae.restapi.ebankingapi.beans.Agence;

import java.util.List;

public interface IAgenceDAO {

    List<Agence> getAllAgences();

    Agence getAgenceById(int id);

    void addAgence(Agence agence);

    void updateAgence(Agence agence);

    void deleteAgence(int id);

    boolean AgenceExists(int id);
}
 