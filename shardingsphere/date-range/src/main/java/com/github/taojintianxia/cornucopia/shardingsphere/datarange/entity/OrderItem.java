package com.github.taojintianxia.cornucopia.shardingsphere.datarange.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Nianjun Sun
 */
@Data
public class OrderItem implements Serializable {
    
    private long orderItemId;

    private long orderId;

    private int userId;

    private String status;
}
