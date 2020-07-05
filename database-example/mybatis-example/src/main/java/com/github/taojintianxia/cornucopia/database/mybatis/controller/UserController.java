package com.github.taojintianxia.cornucopia.database.mybatis.controller;


import com.github.taojintianxia.cornucopia.database.mybatis.model.Order;
import com.github.taojintianxia.cornucopia.database.mybatis.service.OrderService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2020/3/12 12:52
 */
@RestController
public class UserController {
    
    @Autowired
    private OrderService orderService;
    
    @RequestMapping("/listAllOrders")
    public List<Order> listAllOrders() {
        return orderService.listAll();
    }
    
    @RequestMapping("/listOrderByUserIds")
    public List<Order> listOrderByUserId(Integer id) {
        return orderService.listOrdersByUserIds(Lists.newArrayList(id));
    }
}