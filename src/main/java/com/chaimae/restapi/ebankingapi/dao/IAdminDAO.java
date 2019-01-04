package com.chaimae.restapi.ebankingapi.dao;



import com.chaimae.restapi.ebankingapi.beans.Admin;

import java.util.List;

public interface IAdminDAO {

    List<Admin> getAllAdmins();

    Admin getAdminByCin(String cin);

    void addAdmin(Admin admin);

    void updateAdmin(Admin admin);

    void deleteAdmin(String Cin);

    /*boolean AdminExists(String title, String category);*/
}
 