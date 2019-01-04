package com.chaimae.restapi.ebankingapi.dao;



import com.chaimae.restapi.ebankingapi.beans.Client;
import com.chaimae.restapi.ebankingapi.beans.Compte;

import java.util.List;

public interface ICompteDAO {

    List<Compte> getAllComptes();

    Compte getCompteById(int id);

    void addCompte(Compte compte);

    void updateCompte(Compte compte);

    void deleteCompte(int id);

    boolean CompteExists(int id);
}
 