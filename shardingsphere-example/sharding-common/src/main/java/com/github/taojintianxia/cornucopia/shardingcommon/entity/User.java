package com.github.taojintianxia.cornucopia.shardingcommon.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Nianjun Sun
 * @date 2019/8/29 17:38
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 5915686070467656424L;

    private int userId;

    private String userName;

    private String userNamePlain;

    private String pwd;

    private String assistedQueryPwd;
}
