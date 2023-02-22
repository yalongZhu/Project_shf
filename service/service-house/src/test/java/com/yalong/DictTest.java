package com.yalong;

import com.yalong.dao.DictDao;
import com.yalong.entity.Dict;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author yalong
 * @create 2023-02-16-11:11
 */
@ContextConfiguration(locations = "classpath:spring/spring-dao.xml")
@RunWith(SpringRunner.class)
public class DictTest {
    @Autowired
    private DictDao dictDao;

    /*

    */
    @Test
    public void DictTest() {
        List<Dict> listByParentId = dictDao.findListByParentId(1L);
        for (Dict dict : listByParentId) {
            System.out.println(dict);
        }
    }
}
