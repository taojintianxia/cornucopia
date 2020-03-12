package com.github.taojintianxia.cornucopia.database.mybatis.mapper;


import com.github.taojintianxia.cornucopia.database.mybatis.model.User;

import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2020/3/12 12:52
 */
public interface UserMapper {

    List<User> selectAll();

    List<User> selectRange();
}