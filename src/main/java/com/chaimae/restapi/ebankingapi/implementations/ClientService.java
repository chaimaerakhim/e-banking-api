package com.chaimae.restapi.ebankingapi.implementations;

import com.chaimae.restapi.ebankingapi.beans.Client;
import com.chaimae.restapi.ebankingapi.dao.IClientDAO;
import com.chaimae.restapi.ebankingapi.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private IClientDAO ClientDAO;

    @Override
    public List<Client> getAllClients(){
        return ClientDAO.getAllClients();
    }

    @Override
    public Client getClientByCin(String cin) {
        Client obj = ClientDAO.getClientByCin(cin);
        return obj;
    }

    @Override
    public boolean addClient(Client client) {

        ClientDAO.addClient(client);
            return true;
    }



/*    @Override
    public synchronized boolean addClient(Client Client){
        if (ClientDAO.ClientExists(Client.getTitle(), Client.getCategory())) {
            return false;
        } else {
            ClientDAO.addClient(Client);
            return true;
        }
    }*/

    @Override
    public void updateClient(Client Client) {
        ClientDAO.updateClient(Client);
    }

    @Override
    public void deleteClient(String cin) {
        ClientDAO.deleteClient(cin);
    }
}
