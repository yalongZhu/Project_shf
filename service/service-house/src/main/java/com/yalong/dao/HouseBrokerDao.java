package com.yalong.dao;

import com.yalong.entity.HouseBroker;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-16-20:03
 */
public interface HouseBrokerDao extends BaseDao<HouseBroker>{

    //根据房源id查询房源经纪人
    List<HouseBroker> getHouseBrokersByHouseId(Long houseId);
}
