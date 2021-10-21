package com.github.taojintianxia.cornucopia.demo.springmvc.controller;

import com.github.taojintianxia.cornucopia.demo.springmvc.pojo.Order;
import com.github.taojintianxia.cornucopia.demo.springmvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/listAllOrders")
    public List<Order> listAllOrders() {
        return orderService.listAllOrders();
    }
}
