package com.gzr.dao;

import com.gzr.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ${description}
 * Created by GZR
 * 2017-07-04
 */
public interface AdminRepository extends JpaRepository<Admin,Integer>{
    Admin findAdminByUsername(String username);
    Admin findAdminByUsernameAndPassword(String username,String password);
    Admin findAdminByUsernameAndPasswordAndStatus(String username,String password,int status);
    Admin findAdminByStatus(int status);
    Admin findAdminByUsernameAndPasswordAndRole(String username,String password,String role);
}
