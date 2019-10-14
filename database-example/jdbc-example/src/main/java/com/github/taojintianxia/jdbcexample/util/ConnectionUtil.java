package com.github.taojintianxia.jdbcexample.util;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Nianjun Sun
 * @date 2019/9/20 10:50
 */
public class ConnectionUtil {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://127.0.0.1:3307/test?useSSL=false";

    static final String USER = "root";

    static final String PASS = "root";

    @SneakyThrows
    public static Connection getConnection() {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
