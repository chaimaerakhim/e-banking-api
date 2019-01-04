package com.chaimae.restapi.ebankingapi.dao;

import com.chaimae.restapi.ebankingapi.beans.Compte;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class CompteDAO implements ICompteDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Compte getCompteById(int id) {
		return entityManager.find(Compte.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compte> getAllComptes() {
		String hql = "FROM Compte as cl ORDER BY cl.cin";
		return (List<Compte>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addCompte(Compte compte) {
		entityManager.persist(compte);
	}

	@Override
	public void updateCompte(Compte compte) {
		Compte cl = getCompteById(compte.getId());
		cl.setType(compte.getType());
		cl.setSolde(compte.getSolde());

		entityManager.flush();

	}

	@Override
	public void deleteCompte(int id) {
		entityManager.remove(getCompteById(id));
	}

/*	@Override
	public boolean CompteExists(String title, String category) {
		String hql = "'FROM comptes as atcl WHERE atcl.title =' ? 'and atcl.category' = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title)
		              .setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
	}*/
}
