package com.chaimae.restapi.ebankingapi.services;

import com.chaimae.restapi.ebankingapi.beans.Compte;
import com.chaimae.restapi.ebankingapi.beans.Compte;

import java.util.List;

public interface ICompteService {

    List<Compte> getAllComptes();

    Compte getCompteById(int cin);

    boolean addCompte(Compte compte);

    void updateCompte(Compte compte);

    void deleteCompte(int id);
}
