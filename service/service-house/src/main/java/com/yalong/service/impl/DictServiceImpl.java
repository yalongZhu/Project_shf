package com.yalong.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yalong.dao.BaseDao;
import com.yalong.dao.DictDao;
import com.yalong.entity.Dict;
import com.yalong.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yalong
 * @create 2023-02-14-17:11
 */
@Service(interfaceClass = DictService.class)
@Transactional
public class DictServiceImpl extends BaseServiceImpl<Dict> implements DictService {
    @Autowired
    private DictDao dictDao;

    @Override
    protected BaseDao<Dict> getEntityDao() {
        return this.dictDao;
    }

    @Override
    public List<Map<String, Object>> findZnodes(Long id) {
        //根据父id查询所有节点下子节点
        List<Dict> dictList = dictDao.findListByParentId(id);
        //创建返回list
        List<Map<String,Object>> zNodes = new ArrayList<>();
        //遍历dictList
        for (Dict dict : dictList) {
            //返回数据模板[{id:2 , isParent:true , name:"随意勾选 2"}]
            Map map = new HashMap();
            map.put("id",dict.getId());
            map.put("name",dict.getName());
            //判断当前节点是否是父节点
            Integer count = dictDao.isParentNode(dict.getId());
            map.put("isParent",count > 0 ? true:false);
            zNodes.add(map);
        }
        //返回数据
        return zNodes;
    }

    @Override
    public List<Dict> findListByDictCode(String dictCode) {
        Dict dict = dictDao.getDictByDictCode(dictCode);
        if (dict == null) return null;
        //根据父id查询所有子节点方法
        return dictDao.findListByParentId(dict.getId());
    }

    @Override
    public List<Dict> findListByParentId(Long parentId) {
        return dictDao.findListByParentId(parentId);
    }

    @Override
    public String getNameById(Long id) {
        return dictDao.getNameById(id);
    }
}
