package com.chaimae.restapi.ebankingapi.dao;

import com.chaimae.restapi.ebankingapi.beans.Operation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class OperationDAO implements IOperationDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Operation getOperationById(int id) {
		return entityManager.find(Operation.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> getAllOperations() {
		String hql = "FROM Operation as cl ORDER BY cl.cin";
		return (List<Operation>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addOperation(Operation operation) {
		entityManager.persist(operation);
	}

	@Override
	public void updateOperation(Operation operation) {
		Operation cl = getOperationById(operation.getId());
		cl.setSource(operation.getSource());
		cl.setDestination(operation.getDestination());
		cl.setMontant(operation.getMontant());
		cl.setDate(operation.getDate());

		entityManager.flush();
	}

	@Override
	public void deleteOperation(int id) {
		entityManager.remove(getOperationById(id));
	}

	@Override
	public boolean OperationExists(int id) {
		String hql = "'FROM operations as atcl WHERE atcl.id=' ?";
		int count = entityManager.createQuery(hql).setParameter(1, id)
		              .getResultList().size();
		return count > 0 ? true : false;
	}
}
