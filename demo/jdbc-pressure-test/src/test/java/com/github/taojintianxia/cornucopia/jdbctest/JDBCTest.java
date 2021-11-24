package com.github.taojintianxia.cornucopia.jdbctest;

import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.sql.DataSource;

public class JDBCTest {

    public static void main( String... args ) throws Exception {
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(new File("/Users/nianjun/Documents/Cooperation/ICDE/jdbc/local-test.yaml"));
        TransactionTypeHolder.set(TransactionType.XA);
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO t_order (user_id, status) VALUES (?, ?)");
            preparedStatement.setInt(1,new Random().nextInt());
            preparedStatement.setString(2,"test");
            connection.commit();
        } finally {
            TransactionTypeHolder.clear();
        }
    }
}
