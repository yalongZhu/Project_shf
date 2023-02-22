package com.yalong.dao;

import com.yalong.entity.AdminRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-20-21:40
 */
public interface AdminRoleDao extends BaseDao<AdminRole>{
    List<Long> findRoleIdsByAdminId(Long adminId);

    void deleteRoleIdsByAdminId(Long adminId);

    void addRoleIdAndAdminId(@Param("roleId") Long roleId, @Param("adminId") Long adminId);
}
