package com.yalong.dao;

import com.yalong.entity.Role;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-12-11:28
 */
public interface RoleDao extends BaseDao<Role>{
    List<Role> findAll();

}
