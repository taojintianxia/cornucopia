package com.github.taojintianxia.jdbcexample;

import com.github.taojintianxia.jdbcexample.service.CRUDTemplate;
import com.github.taojintianxia.jdbcexample.service.UserServiceImpl;

/**
 * @author Nianjun Sun
 * @date 2019/9/20 10:56
 */
public class JDBCApplication {

    public static void main(String... args) {
        CRUDTemplate userService = new UserServiceImpl();
        userService.init();
    }
}
