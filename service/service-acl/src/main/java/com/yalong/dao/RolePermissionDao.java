package com.yalong.dao;

import com.yalong.entity.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-21-9:39
 */
public interface RolePermissionDao extends BaseDao<RolePermission>{
    //根据角色id查询已分配权限
    List<Long> findPermissionIdByRoleId(Long roleId);
    //根据角色id删除已分配权限
    void deletePermissionIdsByRoleId(Long roleId);
    //添加新的角色id和权限id
    void addPermissionIdAndRoleId(@Param("roleId") Long roleId, @Param("permissionId") Long permissionId);
}
