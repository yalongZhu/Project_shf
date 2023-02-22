package com.yalong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yalong.dao.BaseDao;
import com.yalong.service.BaseService;
import com.yalong.util.CastUtil;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Map;

/**
 * @author yalong
 * @create 2023-02-13-17:29
 */
@Transactional
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    protected abstract BaseDao<T> getEntityDao();

    @Override
    public Integer insert(T t) {
        return getEntityDao().insert(t);
    }

    @Override
    public void delete(Long id) {
        getEntityDao().delete(id);
    }

    @Override
    public Integer update(T t) {
        return getEntityDao().update(t);
    }

    @Override
    public T getById(Serializable id) {
        return getEntityDao().getById(id);
    }

    /**
     * 重写分页，让小区中区域和模块名字赋值
     * @param filters
     * @return
     */
    @Override
    public PageInfo<T> findPage(Map<String, Object> filters) {
        //当前页数
        int pageNum = CastUtil.castInt(filters.get("pageNum"), 1);
        //每页显示的记录条数
        int pageSize = CastUtil.castInt(filters.get("pageSize"), 10);

        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<T>(getEntityDao().findPage(filters), 10);
    }
}
