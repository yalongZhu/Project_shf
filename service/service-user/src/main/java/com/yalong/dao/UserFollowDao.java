package com.yalong.dao;

import com.github.pagehelper.Page;
import com.yalong.entity.UserFollow;
import com.yalong.vo.UserFollowVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author yalong
 * @create 2023-02-20-15:04
 */
public interface UserFollowDao extends BaseDao<UserFollow>{
    Integer getCountByUserIdAndHouseId(@Param("userId") Long userId, @Param("houseId") Long houseId);

    Page<UserFollowVo> findPageList(Long userId);
}
