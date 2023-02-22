package com.yalong.service;

import com.yalong.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * @author yalong
 * @create 2023-02-12-11:34
 */
public interface RoleService extends BaseService<Role>{
    List<Role> findAll();
    //根据用户id查询角色
    Map<String,Object> findRolesByAdminId(Long adminId);

    void assignRole(Long adminId, Long[] roleIds);
}
