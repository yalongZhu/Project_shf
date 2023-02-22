package com.yalong.service;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.Map;

/**
 * @author yalong
 * @create 2023-02-13-17:26
 */
public interface BaseService<T> {
    Integer insert(T t);

    void delete(Long id);

    Integer update(T t);

    T getById(Serializable id);

    PageInfo<T> findPage(Map<String, Object> filters);
}
