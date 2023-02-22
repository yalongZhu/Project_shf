package com.yalong.dao;

import com.yalong.entity.HouseImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-16-20:07
 */
public interface HouseImageDao extends BaseDao<HouseImage>{
    //根据房源id和类型查询房源和房产图片
    List<HouseImage> getHouseImagesByHouseIdAndType(@Param("houseId") Long houseId, @Param("type") Integer type);
}
