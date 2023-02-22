package com.yalong.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yalong.dao.BaseDao;
import com.yalong.dao.HouseUserDao;
import com.yalong.entity.HouseUser;
import com.yalong.service.HouseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-16-20:23
 */
@Service(interfaceClass = HouseUserService.class)
@Transactional
public class HouseUserServiceImpl extends BaseServiceImpl<HouseUser> implements HouseUserService {
    @Autowired
    private HouseUserDao houseUserDao;
    @Override
    protected BaseDao<HouseUser> getEntityDao() {
        return this.houseUserDao;
    }

    @Override
    public List<HouseUser> getHouseUserByHouseId(Long houseId) {
        return houseUserDao.getHouseUserByHouseId(houseId);
    }
}
