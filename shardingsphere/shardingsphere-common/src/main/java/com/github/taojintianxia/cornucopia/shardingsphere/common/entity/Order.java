package com.github.taojintianxia.cornucopia.shardingsphere.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Nianjun Sun
 * @date 2019/8/29 17:38
 */
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = -145160396172182784L;

    private long orderId;

    private int userId;

    private String status;

    private Long addressId;
}
