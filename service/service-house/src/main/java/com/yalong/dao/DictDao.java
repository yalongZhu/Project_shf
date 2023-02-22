package com.yalong.dao;

import com.yalong.entity.Dict;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-14-17:15
 */
public interface DictDao extends BaseDao<Dict>{
    //根据父id查询该节点下所有子节点
    List<Dict> findListByParentId(Long id);
    //根据父id判断当前节点是否是父节点
    Integer isParentNode(Long id);
    //根据编码获取Dict对象
    Dict getDictByDictCode(String dictCode);
    //根据id获取名字
    String getNameById(Long id);
}
