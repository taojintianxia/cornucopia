package com.github.taojintianxia.cornucopia.springcloud.alibaba.dubbo.api.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Nianjun Sun
 */
@Data
public class User implements Serializable {

    private long id;

    private String name;

    private int age;
}
