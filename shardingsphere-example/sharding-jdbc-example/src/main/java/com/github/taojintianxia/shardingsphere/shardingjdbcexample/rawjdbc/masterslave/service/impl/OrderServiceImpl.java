package com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave.service.impl;

import com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.entity.Order;
import com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave.service.MasterSlaveService;
import com.google.common.io.Resources;
import lombok.SneakyThrows;
import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlMasterSlaveDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.net.URL;
import java.sql.PreparedStatement;

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
    @SneakyThrows
    public void save(Order order) {
        String sql = "insert into t_order(order_id,user_id,status) values (null, ?, ?) ";
        PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
        preparedStatement.execute();
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

    public static void main(String... args) throws Exception {
        URL url = Resources.getResource("yaml/raw/master-slave/master-slave.yml");
        DataSource dataSource = YamlMasterSlaveDataSourceFactory.createDataSource(new File(url.getFile()));
        OrderServiceImpl orderService = new OrderServiceImpl(dataSource);
        Order order = new Order();
        order.setUserId(1);
        order.setStatus("WhatEver");
        orderService.save(order);
    }
}
