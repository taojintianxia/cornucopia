package com.github.taojintianxia.cornucopia.shardingsphere.datarange.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Nianjun Sun
 */
@Data
public class Order implements Serializable {
    
    private long orderId;

    private int userId;

    private String status;

    private Long addressId;
    
    private Long createTime;
    
    private Long updateTime;
}
