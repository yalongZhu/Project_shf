package com.yalong.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yalong.dao.BaseDao;
import com.yalong.dao.UserInfoDao;
import com.yalong.entity.UserInfo;
import com.yalong.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yalong
 * @create 2023-02-20-13:21
 */
@Service(interfaceClass = UserInfoService.class)
@Transactional
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    protected BaseDao<UserInfo> getEntityDao() {
        return this.userInfoDao;
    }

    @Override
    public UserInfo getUserInfoByPhone(String phone) {
        return userInfoDao.getUserInfoByPhone(phone);
    }
}
