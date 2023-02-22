package com.yalong.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yalong.dao.AdminDao;
import com.yalong.dao.BaseDao;
import com.yalong.entity.Admin;
import com.yalong.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-13-18:03
 */
@Service(interfaceClass = AdminService.class)
@Transactional
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    protected BaseDao<Admin> getEntityDao() {
        return this.adminDao;
    }

    @Override
    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    @Override
    public Admin getAdminByUsername(String username) {
        Admin admin = adminDao.getAdminByUsername(username);
        return admin;
    }
}
