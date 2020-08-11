package com.github.taojintianxia.cornucopia.shardingsphere.datarange;

import com.google.common.io.Resources;
import lombok.SneakyThrows;
import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;

/**
 * @author Nianjun Sun
 */
public class ExampleMain {

    @SneakyThrows
    public static void main(final String... args) {
        DataSource dataSource = YamlShardingDataSourceFactory.createDataSource(new File(Resources.getResource("sharding-databases-tables-range.yaml").getFile()));
    }
}
