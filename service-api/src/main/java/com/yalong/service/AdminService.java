package com.yalong.service;

import com.yalong.entity.Admin;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-13-18:03
 */
public interface AdminService extends BaseService<Admin>{

    List<Admin> findAll();

    Admin getAdminByUsername(String username);

}
