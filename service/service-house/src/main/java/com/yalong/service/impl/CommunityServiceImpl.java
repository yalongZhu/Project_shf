package com.yalong.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yalong.dao.BaseDao;
import com.yalong.dao.CommunityDao;
import com.yalong.dao.DictDao;
import com.yalong.entity.Community;
import com.yalong.service.CommunityService;
import com.yalong.util.CastUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author yalong
 * @create 2023-02-15-17:25
 */
@Service(interfaceClass = CommunityService.class)
@Transactional
public class CommunityServiceImpl extends BaseServiceImpl<Community> implements CommunityService {
    @Autowired
    private CommunityDao communityDao;
    @Autowired
    private DictDao dictDao;
    @Override
    protected BaseDao<Community> getEntityDao() {
        return this.communityDao;
    }

    @Override
    public PageInfo<Community> findPage(Map<String, Object> filters) {
        //当前页数
        int pageNum = CastUtil.castInt(filters.get("pageNum"), 1);
        //每页显示的记录条数
        int pageSize = CastUtil.castInt(filters.get("pageSize"), 10);

        PageHelper.startPage(pageNum, pageSize);
        //掉头分页及带条件查询方法
        Page<Community> page = communityDao.findPage(filters);
        //遍历对象
        for (Community community : page) {
            //根据区域id和板块id获取名字
            String areaName = dictDao.getNameById(community.getAreaId());
            String plateName = dictDao.getNameById(community.getPlateId());
            //给community对象赋值
            community.setAreaName(areaName);
            community.setPlateName(plateName);
        }
        return new PageInfo<>(page,10);
    }

    @Override
    public List<Community> findAll() {
        return communityDao.findAll();
    }

    /**
     * 为了展示小区区域和板块数字数据
     * @param id
     * @return
     */
    @Override
    public Community getById(Serializable id) {
        Community community = communityDao.getById(id);
        //根据区域id和板块id获取名字
        String areaName = dictDao.getNameById(community.getAreaId());
        String plateName = dictDao.getNameById(community.getPlateId());
        //给community对象赋值
        community.setAreaName(areaName);
        community.setPlateName(plateName);
        return community;
    }
}
