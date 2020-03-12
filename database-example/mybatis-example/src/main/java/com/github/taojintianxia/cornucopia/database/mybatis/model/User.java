package com.github.taojintianxia.cornucopia.database.mybatis.model;

import lombok.Data;

/**
 * @author Nianjun Sun
 * @date 2020/3/12 12:52
 */
@Data
public class User {

    private Long id;

    private String name;

    private Integer age;

    private String email;
}