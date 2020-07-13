package com.github.taojintianxia.cornucopia.database.mybatis.service.impl;

import com.github.taojintianxia.cornucopia.database.mybatis.mapper.OrderMapper;
import com.github.taojintianxia.cornucopia.database.mybatis.model.Order;
import com.github.taojintianxia.cornucopia.database.mybatis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2020/7/5 23:46
 */
@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderMapper orderMapper;
    
    @Override
    public List<Order> listAll() {
        return orderMapper.listAll();
    }
    
    @Override
    public List<Order> listOrdersByUserIds(List<Integer> userIdList) {
        return orderMapper.listByUserIds(userIdList);
    }
    
    @Override
    public int insert(Order order) {
        return orderMapper.insert(order);
    }
    
    @Override
    @Transactional
    public int batchInsert(List<Order> orderList) {
        return orderMapper.batchInsert(orderList);
    }
}
