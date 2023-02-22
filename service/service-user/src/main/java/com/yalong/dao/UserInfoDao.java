package com.yalong.dao;

import com.yalong.entity.UserInfo;

/**
 * @author yalong
 * @create 2023-02-20-13:20
 */
public interface UserInfoDao extends BaseDao<UserInfo>{
    UserInfo getUserInfoByPhone(String phone);
}
