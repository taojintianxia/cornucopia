package com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave.service.impl;

import com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave.service.MasterSlaveService;

import javax.sql.DataSource;

/**
 * @author Nianjun Sun
 * @date 2019/9/2 10:32
 */
public class UserServiceImpl implements MasterSlaveService {

    private DataSource datasource;

    public UserServiceImpl(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public Object getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Object o) {

    }
}
