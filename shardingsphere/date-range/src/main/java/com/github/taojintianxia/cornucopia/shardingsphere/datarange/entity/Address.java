package com.github.taojintianxia.cornucopia.shardingsphere.datarange.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Nianjun Sun
 */

@Data
public class Address implements Serializable {

    private Long id;

    private String name;

    private Long createTime;

    private Long updateTime;
}
