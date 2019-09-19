package com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave.service.impl;

import com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.entity.OrderItem;

import javax.sql.DataSource;

/**
 * @author Nianjun Sun
 * @date 2019/9/2 10:31
 */
public class OrderItemServiceImpl implements CRUDTemplate<OrderItem> {

    private DataSource dataSource;

    public OrderItemServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(OrderItem orderItem) {

    }

    @Override
    public OrderItem getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(OrderItem orderItem) {

    }
}
