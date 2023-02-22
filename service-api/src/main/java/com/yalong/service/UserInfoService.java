package com.yalong.service;

import com.yalong.entity.UserInfo;

/**
 * @author yalong
 * @create 2023-02-20-13:20
 */
public interface UserInfoService extends BaseService<UserInfo>{
    UserInfo getUserInfoByPhone(String phone);
}
