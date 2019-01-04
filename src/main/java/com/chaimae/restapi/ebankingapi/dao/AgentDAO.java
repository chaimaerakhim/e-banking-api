package com.chaimae.restapi.ebankingapi.dao;

import com.chaimae.restapi.ebankingapi.beans.Agent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class AgentDAO implements IAgentDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Agent getAgentByCin(String Cin) {
		return entityManager.find(Agent.class, Cin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agent> getAllAgents() {
		String hql = "FROM Agent as cl ORDER BY cl.cin";
		return (List<Agent>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addAgent(Agent agent) {
		entityManager.persist(agent);
	}

	@Override
	public void updateAgent(Agent agent) {
		Agent cl = getAgentByCin(agent.getCin());
		cl.setNom(agent.getNom());
		cl.setPrenom(agent.getPrenom());
		cl.setLogin(cl.getLogin());
		cl.setPassword(cl.getPassword());
		cl.setEmail(cl.getEmail());
		cl.setAddresse(cl.getAddresse());
		cl.setTel(cl.getTel());
		entityManager.flush();

	}

	@Override
	public void deleteAgent(String cin) {
		entityManager.remove(getAgentByCin(cin));
	}

	@Override
	public boolean AgentExists(String cin) {
		String hql = "'FROM agents as atcl WHERE atcl.cin =' ? '";
		int count = entityManager.createQuery(hql).setParameter(1, cin)
		              .getResultList().size();
		return count > 0 ? true : false;
	}
}
