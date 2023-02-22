package com.yalong.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yalong.dao.BaseDao;
import com.yalong.dao.UserFollowDao;
import com.yalong.entity.UserFollow;
import com.yalong.service.DictService;
import com.yalong.service.UserFollowService;
import com.yalong.vo.UserFollowVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yalong
 * @create 2023-02-20-15:03
 */
@Service(interfaceClass = UserFollowService.class)
@Transactional
public class UserFollowServiceimpl extends BaseServiceImpl<UserFollow> implements UserFollowService {
    @Autowired
    private UserFollowDao userFollowDao;
    @Reference
    private DictService dictService;
    @Override
    protected BaseDao<UserFollow> getEntityDao() {
        return this.userFollowDao;
    }

    @Override
    public void follow(Long id, Long houseId) {
        //创建userFollow对象
        UserFollow userFollow = new UserFollow();
        userFollow.setUserId(id);
        userFollow.setHouseId(houseId);
        //调用dao中添加方法
        userFollowDao.insert(userFollow);
    }

    @Override
    public Boolean isFollowed(Long userId, Long houseId) {
        //调用Dao查询是否关注
        Integer count = userFollowDao.getCountByUserIdAndHouseId(userId,houseId);
        if (count > 0){
            //已关注
            return true;
        }else {
            return false;
        }
    }

    @Override
    public PageInfo<UserFollowVo> findPageList(Integer pageNum, Integer pageSize, Long userId) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        //调用分页方法
        Page<UserFollowVo> page = userFollowDao.findPageList(userId);
        //遍历page
        for (UserFollowVo userFollowVo : page) {
            //获取房屋类型、楼层、朝向
            String houseTypeName = dictService.getNameById(userFollowVo.getHouseTypeId());
            String floorName = dictService.getNameById(userFollowVo.getFloorId());
            String directionName = dictService.getNameById(userFollowVo.getDirectionId());
            userFollowVo.setHouseTypeName(houseTypeName);
            userFollowVo.setFloorName(floorName);
            userFollowVo.setDirectionName(directionName);
        }
        return new PageInfo<>(page,5);
    }

    @Override
    public void cancelFollowed(Long id) {
        //调用删除方法
        userFollowDao.delete(id);
    }
}
