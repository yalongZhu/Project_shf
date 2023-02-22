package com.yalong.service;

import com.github.pagehelper.PageInfo;
import com.yalong.entity.House;
import com.yalong.vo.HouseQueryVo;
import com.yalong.vo.HouseVo;

/**
 * @author yalong
 * @create 2023-02-16-14:37
 */
public interface HouseService extends BaseService<House>{
    void publish(Long houseId, Integer status);

    PageInfo<HouseVo> findPageList(Integer pageNum, Integer pageSize, HouseQueryVo houseQueryVo);
}
