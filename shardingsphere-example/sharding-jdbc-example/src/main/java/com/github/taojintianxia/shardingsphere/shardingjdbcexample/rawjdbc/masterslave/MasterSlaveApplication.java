package com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave;

import com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.enums.ShardingType;
import com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.factory.YamlDataSourceFactory;

import javax.sql.DataSource;

/**
 * @author Nianjun Sun
 * @date 2019/9/2 10:27
 */
public class MasterSlaveApplication {

    private static ShardingType shardingType = ShardingType.SHARDING_TABLES;

    public static void main(String... args) throws Exception {
        DataSource dataSource = YamlDataSourceFactory.newInstance(shardingType);
    }

}
