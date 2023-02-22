package com.yalong.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yalong.dao.BaseDao;
import com.yalong.dao.HouseBrokerDao;
import com.yalong.entity.HouseBroker;
import com.yalong.service.HouseBrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-16-20:18
 */
@Service(interfaceClass = HouseBrokerService.class)
@Transactional
public class HouseBrokerServiceImpl extends BaseServiceImpl<HouseBroker> implements HouseBrokerService {
    @Autowired
    private HouseBrokerDao houseBrokerDao;
    @Override
    protected BaseDao<HouseBroker> getEntityDao() {
        return this.houseBrokerDao;
    }

    @Override
    public List<HouseBroker> getHouseBrokersByHouseId(Long houseId) {
        return houseBrokerDao.getHouseBrokersByHouseId(houseId);
    }
}
