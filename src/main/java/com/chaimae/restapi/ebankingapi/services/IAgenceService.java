package com.chaimae.restapi.ebankingapi.services;

import com.chaimae.restapi.ebankingapi.beans.Agence;
import com.chaimae.restapi.ebankingapi.beans.Operation;

import java.util.List;

public interface IAgenceService {

    List<Agence> getAllAgences();

    Agence getAgenceById(int id);

    boolean addAgence(Operation operation);

    void updateAgence(Agence agence);

    void deleteAgence(int id);
}
