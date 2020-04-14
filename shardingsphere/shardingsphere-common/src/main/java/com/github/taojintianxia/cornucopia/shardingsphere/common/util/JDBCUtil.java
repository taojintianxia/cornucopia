package com.github.taojintianxia.cornucopia.shardingsphere.common.util;

import com.github.taojintianxia.cornucopia.shardingsphere.common.constant.SQLConstant;
import com.google.common.collect.Lists;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2020/4/14 09:41
 */
public class JDBCUtil {

    @SneakyThrows
    public static void execute(DataSource dataSource, String sql) {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        }
    }

    @SneakyThrows
    public static ResultSet executeQuery(DataSource dataSource, String sql) {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        }
    }

    @SneakyThrows
    private static void executeSQLs(DataSource dataSource, List<String> sqlList) {
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            for (String each : sqlList) {
                statement.execute(each);
            }
        }
    }

    public static void createSchema(DataSource dataSource) {
        execute(dataSource, SQLConstant.CREATE_SCHEMA);
    }

    public static void dropSchema(DataSource dataSource) {
        execute(dataSource, SQLConstant.DROP_SCHEMA);
    }

    public static void createTable(DataSource dataSource) {
        executeSQLs(dataSource,
                Lists.newArrayList(SQLConstant.CREATE_TABLE_ORDER, SQLConstant.CREATE_TABLE_ORDER_ITEM));
    }

    public static void initData(DataSource dataSource) {
        createTable(dataSource);
    }
}
