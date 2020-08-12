package com.github.taojintianxia.cornucopia.shardingsphere.datarange;

import com.google.common.io.Resources;
import lombok.SneakyThrows;
import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.Statement;

/**
 * @author Nianjun Sun
 */
public class ExampleMain {

    @SneakyThrows
    public static void main(final String... args) {
        String sql = "insert into t_order(order_id,user_id,address_id,status,create_time,update_time) values (null,1,1,1,\"\",1578730041,1578730041)";
        DataSource dataSource = YamlShardingDataSourceFactory.createDataSource(new File(Resources.getResource("sharding-databases-tables-range.yaml").getFile()));
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }
}
