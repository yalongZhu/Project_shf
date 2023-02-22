package com.yalong.service;

import com.yalong.entity.HouseImage;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-16-20:16
 */
public interface HouseImageService extends BaseService<HouseImage>{
    //根据房源id和类型查询房源和房产图片
    List<HouseImage> getHouseImagesByHouseIdAndType(Long houseId, Integer type);

}
