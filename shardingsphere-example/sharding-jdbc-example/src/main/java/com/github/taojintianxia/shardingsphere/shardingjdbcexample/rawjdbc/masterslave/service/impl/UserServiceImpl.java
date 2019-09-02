package com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave.service.impl;

import com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.entity.User;
import com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave.service.MasterSlaveService;

import javax.sql.DataSource;

/**
 * @author Nianjun Sun
 * @date 2019/9/2 10:32
 */
public class UserServiceImpl implements MasterSlaveService<User> {

    private DataSource datasource;

    public UserServiceImpl(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(User user) {

    }
}
