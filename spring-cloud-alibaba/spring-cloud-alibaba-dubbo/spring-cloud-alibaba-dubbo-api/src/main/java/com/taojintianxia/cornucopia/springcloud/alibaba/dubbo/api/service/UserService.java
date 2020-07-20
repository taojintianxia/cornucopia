package com.taojintianxia.cornucopia.springcloud.alibaba.dubbo.api.service;

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
