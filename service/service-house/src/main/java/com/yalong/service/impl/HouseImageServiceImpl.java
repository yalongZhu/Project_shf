package com.yalong.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yalong.dao.BaseDao;
import com.yalong.dao.HouseImageDao;
import com.yalong.entity.HouseImage;
import com.yalong.service.HouseImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-16-20:21
 */
@Service(interfaceClass = HouseImageService.class)
@Transactional
public class HouseImageServiceImpl extends BaseServiceImpl<HouseImage> implements HouseImageService {
    @Autowired
    private HouseImageDao houseImageDao;
    @Override
    protected BaseDao<HouseImage> getEntityDao() {
        return this.houseImageDao;
    }

    @Override
    public List<HouseImage> getHouseImagesByHouseIdAndType(Long houseId, Integer type) {
        return houseImageDao.getHouseImagesByHouseIdAndType(houseId,type);
    }
}
