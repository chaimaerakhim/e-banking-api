package com.chaimae.restapi.ebankingapi.implementations;

import com.chaimae.restapi.ebankingapi.beans.Admin;
import com.chaimae.restapi.ebankingapi.dao.IAdminDAO;
import com.chaimae.restapi.ebankingapi.services.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private IAdminDAO AdminDAO;

    @Override
    public List<Admin> getAllAdmins(){
        return AdminDAO.getAllAdmins();
    }

    @Override
    public Admin getAdminByCin(String cin) {
        Admin obj = AdminDAO.getAdminByCin(cin);
        return obj;
    }

    @Override
    public boolean addAdmin(Admin admin) {

        AdminDAO.addAdmin(admin);
            return true;
    }



/*    @Override
    public synchronized boolean addAdmin(Admin Admin){
        if (AdminDAO.AdminExists(Admin.getTitle(), Admin.getCategory())) {
            return false;
        } else {
            AdminDAO.addAdmin(Admin);
            return true;
        }
    }*/

    @Override
    public void updateAdmin(Admin Admin) {
        AdminDAO.updateAdmin(Admin);
    }

    @Override
    public void deleteAdmin(String cin) {
        AdminDAO.deleteAdmin(cin);
    }
}
