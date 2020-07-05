package com.github.taojintianxia.cornucopia.database.mybatis.model;

import lombok.Data;

/**
 * @author Nianjun Sun
 * @date 2020/3/12 12:52
 */
@Data
public class Order {
    
    private Long id;
    
    private Integer userId;
    
    private String status;
}