package com.github.taojintianxia.cornucopia.springcloud.alibaba.dubbo.api.service;

import com.github.taojintianxia.cornucopia.springcloud.alibaba.dubbo.api.entity.User;

/**
 * @author Nianjun Sun
 */
public interface UserService {

    /**
     * get user by user id
     *
     * @param userId
     * @return User
     */
    User getUserById(long userId);
}
