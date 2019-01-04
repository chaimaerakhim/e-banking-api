package com.chaimae.restapi.ebankingapi.services;

import com.chaimae.restapi.ebankingapi.beans.Agence;
import com.chaimae.restapi.ebankingapi.beans.Agence;

import java.util.List;

public interface IAgenceService {

    List<Agence> getAllAgences();

    Agence getAgenceById(int id);

    boolean addAgence(Agence agence);

    void updateAgence(Agence agence);

    void deleteAgence(int id);
}
