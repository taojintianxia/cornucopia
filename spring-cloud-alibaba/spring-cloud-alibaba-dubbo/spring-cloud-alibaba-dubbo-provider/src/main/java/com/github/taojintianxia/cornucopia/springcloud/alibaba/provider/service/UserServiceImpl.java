package com.github.taojintianxia.cornucopia.springcloud.alibaba.provider.service;

import com.github.taojintianxia.cornucopia.springcloud.alibaba.dubbo.api.entity.User;
import com.github.taojintianxia.cornucopia.springcloud.alibaba.dubbo.api.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author ZhangShuzheng
 * @date 2019/5/8
 */
@Service
public class UserServiceImpl implements UserService {

    @Value("${server.port}")
    private Integer port;

    @Override
    public User getUserById(long userId) {
        User user = new User();
        user.setId(port);
        return user;
    }
}
