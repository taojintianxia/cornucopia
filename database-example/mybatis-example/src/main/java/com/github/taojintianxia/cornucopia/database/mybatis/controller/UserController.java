package com.github.taojintianxia.cornucopia.database.mybatis.controller;


import com.github.taojintianxia.cornucopia.database.mybatis.mapper.UserMapper;
import com.github.taojintianxia.cornucopia.database.mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2020/3/12 12:52
 */
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/selectAllUsers")
    public List<User> getUsers() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @RequestMapping("/selectRange")
    public List<User> getUser(Long id) {
        List<User> users = userMapper.selectRange();
        return users;
    }
}