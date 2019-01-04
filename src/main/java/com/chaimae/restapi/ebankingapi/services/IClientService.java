package com.chaimae.restapi.ebankingapi.services;

import com.chaimae.restapi.ebankingapi.beans.Client;

import java.util.List;

public interface IClientService {


   List<Client> getAllClients();

   Client getClientByCin(String cin);

   boolean addClient(Client Client);

   void updateClient(Client Client);

   void deleteClient(String cin);

    }
