package com.chaimae.restapi.ebankingapi.services;


import com.chaimae.restapi.ebankingapi.beans.Operation;

import java.util.List;

public interface IOperationService {

    List<Operation> getAllOperations();

    Operation getOperationById(int id);

    boolean addOperation(Operation operation);

    void updateOperation(Operation operation);

    void deleteOperation(int id);
}
