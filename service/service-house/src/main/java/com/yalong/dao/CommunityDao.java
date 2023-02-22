package com.yalong.dao;

import com.yalong.entity.Community;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-15-17:18
 */
public interface CommunityDao extends BaseDao<Community>{
    List<Community> findAll();
}
