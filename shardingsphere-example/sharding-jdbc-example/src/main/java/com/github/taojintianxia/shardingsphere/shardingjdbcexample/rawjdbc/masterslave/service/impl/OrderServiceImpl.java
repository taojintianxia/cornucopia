package com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave.service.impl;

import com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.entity.Order;
import com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave.service.MasterSlaveService;

import javax.sql.DataSource;

/**
 * @author Nianjun Sun
 * @date 2019/9/2 10:32
 */
public class OrderServiceImpl implements MasterSlaveService<Order> {

    private DataSource dataSource;

    public OrderServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void save(Order order) {

    }

    @Override
    public Order getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Order order) {

    }
}
