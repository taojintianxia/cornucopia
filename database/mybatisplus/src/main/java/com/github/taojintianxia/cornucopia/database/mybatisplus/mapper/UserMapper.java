package com.github.taojintianxia.cornucopia.database.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.taojintianxia.cornucopia.database.mybatisplus.entity.User;

import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2020/1/7 17:38
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> selectAll();

    List<User> selectRange();
}