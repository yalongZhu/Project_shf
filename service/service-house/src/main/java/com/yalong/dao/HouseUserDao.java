package com.yalong.dao;

import com.yalong.entity.HouseUser;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-16-20:12
 */
public interface HouseUserDao extends BaseDao<HouseUser>{
    //根据房源id查询房东信息
    List<HouseUser> getHouseUserByHouseId(Long houseId);
}
