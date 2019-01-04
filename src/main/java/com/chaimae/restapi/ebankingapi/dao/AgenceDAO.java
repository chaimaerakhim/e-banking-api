package com.chaimae.restapi.ebankingapi.dao;

import com.chaimae.restapi.ebankingapi.beans.Agence;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class AgenceDAO implements IAgenceDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Agence getAgenceById(int id) {
		return entityManager.find(Agence.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agence> getAllAgences() {
		String hql = "FROM Agence as cl ORDER BY cl.cin";
		return (List<Agence>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addAgence(Agence agence) {
		entityManager.persist(agence);
	}

	@Override
	public void updateAgence(Agence agence) {
		Agence cl = getAgenceById(agence.getId());
		cl.setNom(cl.getNom());
		cl.setAdresse(cl.getAdresse());
		cl.setTel(cl.getTel());
		cl.setSolde_totale(cl.getSolde_totale());

		entityManager.flush();

	}

	@Override
	public void deleteAgence(int id) {
		entityManager.remove(getAgenceById(id));
	}

	@Override
	public boolean AgenceExists(int id){
		String hql = "'FROM agences as atcl WHERE atcl.id=' ?";
		int count = entityManager.createQuery(hql).setParameter(1, id)
		              .getResultList().size();
		return count > 0 ? true : false;
	}
}
