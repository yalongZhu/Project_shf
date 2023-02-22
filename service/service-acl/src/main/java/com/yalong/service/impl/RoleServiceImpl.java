package com.yalong.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yalong.dao.AdminRoleDao;
import com.yalong.dao.BaseDao;
import com.yalong.dao.RoleDao;
import com.yalong.entity.Role;
import com.yalong.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yalong
 * @create 2023-02-12-11:35
 */
@Service(interfaceClass = RoleService.class)
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private AdminRoleDao adminRoleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Map<String, Object> findRolesByAdminId(Long adminId) {
        //获取所有角色
        List<Role> roleList = roleDao.findAll();
        //获取用户已拥有角色的角色id
        List<Long> roleIdList = adminRoleDao.findRoleIdsByAdminId(adminId);
        //创建两个List，一个存放未选中，一个存放已选中
        List<Role> noAssignRoleList = new ArrayList<>();
        List<Role> assignRoleList = new ArrayList<>();
        for (Role role : roleList) {
            //判断当前角色是否在roleIdList
            if (roleIdList.contains(role.getId())){
                //已选中
                assignRoleList.add(role);
            }else {
                //未选中
                noAssignRoleList.add(role);
            }
        }
        //创建返回Map
        Map<String, Object> roleMap = new HashMap<>();
        roleMap.put("noAssignRoleList",noAssignRoleList);
        roleMap.put("assignRoleList",assignRoleList);
        return roleMap;
    }

    @Override
    public void assignRole(Long adminId, Long[] roleIds) {
        //根据用户id将已分配角色删除
        adminRoleDao.deleteRoleIdsByAdminId(adminId);
        //遍历所有角色id
        for (Long roleId : roleIds) {
            if (roleId != null){
                //角色id和用户id插入数据库
                adminRoleDao.addRoleIdAndAdminId(roleId,adminId);
            }
        }
    }

    @Override
    protected BaseDao<Role> getEntityDao() {
        return this.roleDao;
    }
}
