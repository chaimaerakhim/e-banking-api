package com.chaimae.restapi.ebankingapi.implementations;

import com.chaimae.restapi.ebankingapi.beans.Operation;
import com.chaimae.restapi.ebankingapi.dao.IOperationDAO;
import com.chaimae.restapi.ebankingapi.services.IOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService implements IOperationService {

    @Autowired
    private IOperationDAO OperationDAO;

    @Override
    public List<Operation> getAllOperations(){
        return OperationDAO.getAllOperations();
    }

    @Override
    public Operation getOperationById(int id) {
        Operation obj = OperationDAO.getOperationById(id);
        return obj;
    }

    @Override
    public boolean addOperation(Operation operation) {

        OperationDAO.addOperation(operation);
            return true;
    }



/*    @Override
    public synchronized boolean addOperation(Operation Operation){
        if (OperationDAO.OperationExists(Operation.getTitle(), Operation.getCategory())) {
            return false;
        } else {
            OperationDAO.addOperation(Operation);
            return true;
        }
    }*/

    @Override
    public void updateOperation(Operation Operation) {
        OperationDAO.updateOperation(Operation);
    }

    @Override
    public void deleteOperation(int id) {
        OperationDAO.deleteOperation(id);
    }
}
