package com.chaimae.restapi.ebankingapi.implementations;

import com.chaimae.restapi.ebankingapi.beans.Compte;
import com.chaimae.restapi.ebankingapi.dao.ICompteDAO;
import com.chaimae.restapi.ebankingapi.services.ICompteService;
import com.chaimae.restapi.ebankingapi.services.ICompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService implements ICompteService {

    @Autowired
    private ICompteDAO CompteDAO;

    @Override
    public List<Compte> getAllComptes(){
        return CompteDAO.getAllComptes();
    }

    @Override
    public Compte getCompteById(int id) {
        Compte obj = CompteDAO.getCompteById(id);
        return obj;
    }

    @Override
    public boolean addCompte(Compte compte) {

        CompteDAO.addCompte(compte);
            return true;
    }



/*    @Override
    public synchronized boolean addCompte(Compte Compte){
        if (CompteDAO.CompteExists(Compte.getTitle(), Compte.getCategory())) {
            return false;
        } else {
            CompteDAO.addCompte(Compte);
            return true;
        }
    }*/

    @Override
    public void updateCompte(Compte Compte) {
        CompteDAO.updateCompte(Compte);
    }

    @Override
    public void deleteCompte(int id) {
        CompteDAO.deleteCompte(id);
    }
}
