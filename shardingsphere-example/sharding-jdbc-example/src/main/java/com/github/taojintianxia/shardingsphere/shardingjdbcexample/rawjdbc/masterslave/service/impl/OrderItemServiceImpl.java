package com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave.service.impl;

import com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave.service.MasterSlaveService;

import javax.sql.DataSource;

/**
 * @author Nianjun Sun
 * @date 2019/9/2 10:31
 */
public class OrderItemServiceImpl implements MasterSlaveService {

    private DataSource dataSource;

    public OrderItemServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
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
