package com.chaimae.restapi.ebankingapi.services;

import com.chaimae.restapi.ebankingapi.beans.Admin;
import com.chaimae.restapi.ebankingapi.beans.Operation;

import java.util.List;

public interface IAdminService {

    List<Admin> getAllAdmins();

    Admin getAdminByCin(String cin);

    boolean addAdmin(Admin admin);

    void updateAdmin(Admin admin);

    void deleteAdmin(String cin);
}
