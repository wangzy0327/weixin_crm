package com.weixin.dao;

import com.weixin.entity.User;

public interface UserDao {
    /**
     * 查询用户
     * @param userId
     * @return
     */
    User queryById(int userId);
}
