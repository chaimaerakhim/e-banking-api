package com.chaimae.restapi.ebankingapi.dao;



import com.chaimae.restapi.ebankingapi.beans.Client;

import java.util.List;

public interface IClientDAO {

    List<Client> getAllClients();

    Client getClientByCin(String cin);

    void addClient(Client Client);

    void updateClient(Client Client);

    void deleteClient(String Cin);

    /*boolean ClientExists(String title, String category);*/
}
 