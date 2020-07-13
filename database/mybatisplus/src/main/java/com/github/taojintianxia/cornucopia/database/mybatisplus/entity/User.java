package com.github.taojintianxia.cornucopia.database.mybatisplus.entity;

import lombok.Data;

/**
 * @author Nianjun Sun
 * @date 2020/1/7 17:39
 */
@Data
//@TableName("user")
public class User {

    private Long id;

    private String name;

    private Integer age;

    private String email;
}