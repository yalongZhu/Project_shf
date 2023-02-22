package com.yalong.service;

import com.yalong.entity.HouseBroker;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-16-20:15
 */
public interface HouseBrokerService extends BaseService<HouseBroker>{
    //根据房源id查询房源经纪人
    List<HouseBroker> getHouseBrokersByHouseId(Long houseId);
}
