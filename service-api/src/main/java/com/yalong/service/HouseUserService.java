package com.yalong.service;

import com.yalong.entity.HouseUser;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-16-20:18
 */
public interface HouseUserService extends BaseService<HouseUser>{
    //根据房源id查询房东信息
    List<HouseUser> getHouseUserByHouseId(Long houseId);

}
