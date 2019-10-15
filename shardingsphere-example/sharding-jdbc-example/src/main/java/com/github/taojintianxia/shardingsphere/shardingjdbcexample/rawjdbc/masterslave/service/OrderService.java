package com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave.service;

import com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.entity.Order;

import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2019/10/15 19:20
 */
public interface OrderService {

    void saveOrder(Order order);

    void deleteOder(Long orderId);

    List<Order> listOrders();
}
