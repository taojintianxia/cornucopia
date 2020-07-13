package com.github.taojintianxia.cornucopia.database.mybatis.service;

import com.github.taojintianxia.cornucopia.database.mybatis.model.Order;

import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2020/7/5 23:44
 */
public interface OrderService {
    
    List<Order> listAll();
    
    List<Order> listOrdersByUserIds(List<Integer> userIdList);
    
    int insert(Order order);
    
    int batchInsert(List<Order> orderList);
}
