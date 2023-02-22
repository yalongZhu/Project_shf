package com.yalong.service;

import com.yalong.entity.Dict;

import java.util.List;
import java.util.Map;

/**
 * @author yalong
 * @create 2023-02-14-17:10
 */
public interface DictService extends BaseService<Dict>{
    //根据id查询数据字典
    List<Map<String, Object>> findZnodes(Long id);
    //根据编码获取该节点下所有子节点
    List<Dict> findListByDictCode(String dictCode);
    //根据父id获取该节点下所有子节点
    List<Dict> findListByParentId(Long parentId);

    String getNameById(Long id);
}
