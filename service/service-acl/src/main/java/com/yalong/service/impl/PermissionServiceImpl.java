package com.yalong.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yalong.dao.BaseDao;
import com.yalong.dao.PermissionDao;
import com.yalong.dao.RolePermissionDao;
import com.yalong.entity.Permission;
import com.yalong.helper.PermissionHelper;
import com.yalong.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yalong
 * @create 2023-02-21-9:33
 */
@Service(interfaceClass = PermissionService.class)
@Transactional
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private RolePermissionDao rolePermissionDao;
    @Override
    protected BaseDao<Permission> getEntityDao() {
        return this.permissionDao;
    }

    @Override
    public List<Map<String, Object>> findPermissionsByRoleId(Long roleId) {
        //获取所有权限
        List<Permission> permissionList = permissionDao.findAll();
        //根据角色id查询已分配的权限id
        List<Long> permissionIdList = rolePermissionDao.findPermissionIdByRoleId(roleId);
        //创建返回数据的list
        List<Map<String, Object>> returnList = new ArrayList<>();
        //遍历所有权限
        for (Permission permission : permissionList) {
            Map<String,Object> map = new HashMap();
            //返回数据格式:{ id:2, pId:0, name:"随意勾选 2", checked:true, open:true}
            map.put("id",permission.getId());
            map.put("pId",permission.getParentId());
            map.put("name",permission.getName());
            //判断当前权限id是否在已分配权限id中
            if (permissionIdList.contains(permission.getId())){
                //已分配
                map.put("checked",true);
            }
            returnList.add(map);
        }
        return returnList;
    }

    @Override
    public void assignPermission(Long roleId, Long[] permissionIds) {
        //调用RolePermissionDao中根据角色id删除已分配权限
        rolePermissionDao.deletePermissionIdsByRoleId(roleId);
        for (Long permissionId : permissionIds) {
            if (permissionId != null){
                rolePermissionDao.addPermissionIdAndRoleId(roleId,permissionId);
            }
        }
    }

    @Override
    public List<Permission> getMenuPermissionByAdminId(Long userId) {
        List<Permission> permissionList;
        //判断是否是系统管理员
        if (userId == 1){
            //系统管理员
            permissionList = permissionDao.findAll();
        }else {
            //根据用户id查询权限菜单
            permissionList = permissionDao.getMenuPermissionsByAdminId(userId);
        }
        //通过permissionHelper将list转换成树形结构
        List<Permission> treeList = PermissionHelper.bulid(permissionList);
        return treeList;
    }

    @Override
    public List<Permission> findAllMenu() {
        List<Permission> permissionlist = permissionDao.findAll();
        if (CollectionUtils.isEmpty(permissionlist)){
            return null;
        }
        //把权限数据构建成树形结构
        List<Permission> treeList = PermissionHelper.bulid(permissionlist);
        return treeList;
    }

    @Override
    public List<String> getPermissionCodesByAdminId(Long id) {
        List<String> permissionCodes;
        if (id == 1){
            //系统管理员
            permissionCodes = permissionDao.getAllPermissionCodes();
        }else {
            //根据用户id查权限码
            permissionCodes = permissionDao.getPermissionCodesByAdminId(id);
        }
        return permissionCodes;
    }
}
