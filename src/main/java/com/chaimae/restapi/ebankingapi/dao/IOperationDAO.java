package com.chaimae.restapi.ebankingapi.dao;



import com.chaimae.restapi.ebankingapi.beans.Operation;

import java.util.List;

public interface IOperationDAO {

    List<Operation> getAllOperations();

    Operation getOperationById(int id);

    void addOperation(Operation operation);

    void updateOperation(Operation operation);

    void deleteOperation(int id);

    boolean OperationExists(int id);
}
 