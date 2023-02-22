package com.yalong.service;

import com.yalong.entity.Community;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-15-17:24
 */
public interface CommunityService extends BaseService<Community>{
    List<Community> findAll();
}
