package com.chaimae.restapi.ebankingapi.dao;

import com.chaimae.restapi.ebankingapi.beans.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class ClientDAO implements IClientDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Client getClientByCin(String Cin) {
		return entityManager.find(Client.class, Cin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> getAllClients() {
		String hql = "FROM Client as cl ORDER BY cl.cin";
		return (List<Client>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addClient(Client client) {
		entityManager.persist(client);
	}

	@Override
	public void updateClient(Client client) {
		Client cl = getClientByCin(client.getCin());
		cl.setNom(client.getNom());
		cl.setPrenom(client.getPrenom());
		cl.setLogin(cl.getLogin());
		cl.setPassword(cl.getPassword());
		cl.setEmail(cl.getEmail());
		cl.setAddresse(cl.getAddresse());
		cl.setTel(cl.getTel());
		cl.setId_compte(cl.getId_compte());
		entityManager.flush();

	}

	@Override
	public void deleteClient(String cin) {
		entityManager.remove(getClientByCin(cin));
	}

/*	@Override
	public boolean ClientExists(String title, String category) {
		String hql = "'FROM clients as atcl WHERE atcl.title =' ? 'and atcl.category' = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title)
		              .setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
	}*/
}
