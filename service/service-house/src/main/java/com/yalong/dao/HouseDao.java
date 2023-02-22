package com.yalong.dao;

import com.github.pagehelper.Page;
import com.yalong.entity.House;
import com.yalong.vo.HouseQueryVo;
import com.yalong.vo.HouseVo;

/**
 * @author yalong
 * @create 2023-02-16-14:40
 */
public interface HouseDao extends BaseDao<House>{
    Page<HouseVo> findPageList(HouseQueryVo houseQueryVo);
}
