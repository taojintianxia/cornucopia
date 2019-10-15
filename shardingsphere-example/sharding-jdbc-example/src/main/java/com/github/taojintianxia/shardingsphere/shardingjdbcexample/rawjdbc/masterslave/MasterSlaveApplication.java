package com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave;

import com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.enums.ShardingType;
import com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.factory.YamlDataSourceFactory;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

/**
 * @author Nianjun Sun
 * @date 2019/9/2 10:27
 */
public class MasterSlaveApplication {

    private static ShardingType shardingType = ShardingType.SHARDING_TABLES;

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS t_order_# (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id))";

    @SneakyThrows
    public static void main(String... args) {
        DataSource dataSource = YamlDataSourceFactory.newInstance(shardingType);
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(CREATE_TABLE);
    }

}
