package com.github.taojintianxia.cornucopia.shardingsphere.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Nianjun Sun
 * @date 2019/8/29 17:38
 */
@Data
@TableName(value = "t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = -6296752216947577911L;

    private long orderId;

    private int userId;

    private String status;

    private Long addressId;
}
