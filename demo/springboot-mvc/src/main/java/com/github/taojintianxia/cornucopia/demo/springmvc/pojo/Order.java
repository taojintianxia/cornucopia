package com.github.taojintianxia.cornucopia.demo.springmvc.pojo;

import lombok.Data;

@Data
public class Order {

    private int orderId;

    private int userId;

    private String status;
}
