package com.yalong.service;

import com.github.pagehelper.PageInfo;
import com.yalong.entity.UserFollow;
import com.yalong.vo.UserFollowVo;

/**
 * @author yalong
 * @create 2023-02-20-15:02
 */
public interface UserFollowService extends BaseService<UserFollow>{
    //关注房源
    void follow(Long id, Long houseId);
    //根据userId和houseId查询是否关注房源
    Boolean isFollowed(Long userId, Long houseId);
    //分页查询关注房源
    PageInfo<UserFollowVo> findPageList(Integer pageNum, Integer pageSize, Long userId);

    void cancelFollowed(Long id);
}
