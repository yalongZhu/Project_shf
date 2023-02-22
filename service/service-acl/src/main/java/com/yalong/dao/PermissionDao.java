package com.yalong.dao;

import com.yalong.entity.Permission;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-21-9:35
 */
public interface PermissionDao extends BaseDao<Permission>{
    //查询所有权限
    List<Permission> findAll();

    List<Permission> getMenuPermissionsByAdminId(Long userId);

    List<String> getAllPermissionCodes();

    List<String> getPermissionCodesByAdminId(Long id);
}
