package com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Nianjun Sun
 * @date 2019/8/29 17:39
 */
@Data
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 8430520334443007174L;

    private long orderItemId;

    private long orderId;

    private int userId;

    private String status;
}
