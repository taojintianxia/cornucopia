package com.github.taojintianxia.cornucopia.demo.springmvc.controller;

import com.github.taojintianxia.cornucopia.demo.springmvc.pojo.Order;
import com.github.taojintianxia.cornucopia.demo.springmvc.service.OrderServiceJDBC;
import com.github.taojintianxia.cornucopia.demo.springmvc.service.OrderServiceJDBCTemplate;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderServiceJDBC orderServiceJDBC;

    @Autowired
    private OrderServiceJDBCTemplate orderServiceJDBCTemplate;

    @GetMapping("/listAllOrders")
    @SneakyThrows
    public List<Order> listAllOrders() {
        return orderServiceJDBC.listAllOrders();
    }

    @GetMapping("/listAllOrdersByTemplate")
    @SneakyThrows
    public List<Order> listAllOrdersByTemplate() {
        return orderServiceJDBCTemplate.listAllOrders();
    }
}
