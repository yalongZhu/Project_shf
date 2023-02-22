package com.yalong.service;

import com.yalong.entity.Permission;

import java.util.List;
import java.util.Map;

/**
 * @author yalong
 * @create 2023-02-21-9:33
 */
public interface PermissionService extends BaseService<Permission>{
    List<Map<String, Object>> findPermissionsByRoleId(Long roleId);

    void assignPermission(Long roleId, Long[] permissionIds);

    List<Permission> getMenuPermissionByAdminId(Long userId);

    List<Permission> findAllMenu();

    List<String> getPermissionCodesByAdminId(Long id);
}
