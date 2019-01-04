package com.chaimae.restapi.ebankingapi.dao;

import com.chaimae.restapi.ebankingapi.beans.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class AdminDAO implements IAdminDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Admin getAdminByCin(String Cin) {
		return entityManager.find(Admin.class, Cin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> getAllAdmins() {
		String hql = "FROM Admin as cl ORDER BY cl.cin";
		return (List<Admin>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addAdmin(Admin admin) {
		entityManager.persist(admin);
	}

	@Override
	public void updateAdmin(Admin admin) {
		Admin cl = getAdminByCin(admin.getCin());
		cl.setNom(admin.getNom());
		cl.setPrenom(admin.getPrenom());
		cl.setLogin(cl.getLogin());
		cl.setPassword(cl.getPassword());
		cl.setEmail(cl.getEmail());
		cl.setAddresse(cl.getAddresse());
		cl.setTel(cl.getTel());
		//cl.setId_compte(cl.getId_compte());
		entityManager.flush();

	}

	@Override
	public void deleteAdmin(String cin) {
		entityManager.remove(getAdminByCin(cin));
	}

	@Override
	public boolean AdminExists(String cin) {
		String hql = "'FROM admins as atcl WHERE atcl.cin =' ? ";
		int count = entityManager.createQuery(hql).setParameter(1, cin)
		              .getResultList().size();
		return count > 0 ? true : false;
	}
}
