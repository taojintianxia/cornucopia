package com.github.taojintianxia.jdbcexample.util;

import com.github.taojintianxia.jdbcexample.constants.JdbcConstant;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @author Nianjun Sun
 * @date 2019/9/20 10:50
 */
public class ConnectionUtil {

    @SneakyThrows
    public static Connection getConnection() {
        Properties properties = PropertiesReader.readProperties();
        Class.forName(properties.getProperty(JdbcConstant.DRIVER_CLASS_NAME));
        return DriverManager
                .getConnection(properties.getProperty(JdbcConstant.URL), properties.getProperty(JdbcConstant.USERNAME),
                        properties.getProperty(JdbcConstant.PASSWORD));
    }

}
