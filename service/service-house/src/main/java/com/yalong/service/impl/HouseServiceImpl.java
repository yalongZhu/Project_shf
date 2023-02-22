package com.yalong.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yalong.dao.BaseDao;
import com.yalong.dao.DictDao;
import com.yalong.dao.HouseDao;
import com.yalong.entity.House;
import com.yalong.service.HouseService;
import com.yalong.vo.HouseQueryVo;
import com.yalong.vo.HouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @author yalong
 * @create 2023-02-16-14:37
 */
@Service(interfaceClass = HouseService.class)
@Transactional
public class HouseServiceImpl extends BaseServiceImpl<House> implements HouseService {

    @Autowired
    private HouseDao houseDao;
    @Autowired
    private DictDao dictDao;
    @Override
    protected BaseDao<House> getEntityDao() {
        return this.houseDao;
    }

    @Override
    public void publish(Long houseId, Integer status) {
        //创建对应对象，设置publish的数据
        House house = new House();
        house.setId(houseId);
        house.setStatus(status);
        houseDao.update(house);
    }

    @Override
    public PageInfo<HouseVo> findPageList(Integer pageNum, Integer pageSize, HouseQueryVo houseQueryVo) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        //分页及带条件查询
        Page<HouseVo> page = houseDao.findPageList(houseQueryVo);
        //变量page
        for (HouseVo houseVo : page) {
            //获取房屋类型、朝向、楼层
            String houseTypeName = dictDao.getNameById(houseVo.getHouseTypeId());
            String floorName = dictDao.getNameById(houseVo.getFloorId());
            String directionName = dictDao.getNameById(houseVo.getDirectionId());
            houseVo.setHouseTypeName(houseTypeName);
            houseVo.setDirectionName(directionName);
            houseVo.setFloorName(floorName);
        }
        return new PageInfo<>(page,5);
    }


    /**
     * 为了展示户型、楼层等数字数据
     * @param id
     * @return
     */
    @Override
    public House getById(Serializable id) {
        House house = houseDao.getById(id);
        //户型
        String houseTypeName = dictDao.getNameById(house.getHouseTypeId());
        //楼层
        String floorName = dictDao.getNameById(house.getFloorId());
        //朝向
        String directionName = dictDao.getNameById(house.getDirectionId());
        //建筑结构
        String buildStructureName = dictDao.getNameById(house.getBuildStructureId());
        //装修情况
        String decorationName = dictDao.getNameById(house.getDecorationId());
        //房屋用途
        String houseUseName = dictDao.getNameById(house.getHouseUseId());
        house.setHouseTypeName(houseTypeName);
        house.setFloorName(floorName);
        house.setDirectionName(directionName);
        house.setBuildStructureName(buildStructureName);
        house.setDecorationName(decorationName);
        house.setHouseUseName(houseUseName);
        return house;
    }
}
