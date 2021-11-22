package com.github.taojintianxia.cornucopia.jdbctest;

import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

public class JDBCTest {

    public static void main( String... args ) throws Exception {
        String configurationFile = System.getProperty("conf");
        int time = Integer.parseInt(System.getProperty("time"));
        int thread = Integer.parseInt(System.getProperty("thread"));
        int TABLE_SIZE = Integer.parseInt(System.getProperty("table-size"));
        if (configurationFile == null) {
            throw new RuntimeException("\"-Dcon\" has not been set");
        }
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(new File(configurationFile));
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from sbtest1 limit 1");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
    }
}
