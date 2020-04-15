package com.github.taojintianxia.conuporpia.shardingsphere.shardingcore.rawjdbc.shardingdatabase;

import com.github.taojintianxia.cornucopia.shardingsphere.common.constant.SQLConstant;
import com.github.taojintianxia.cornucopia.shardingsphere.common.enums.ShardingType;
import com.github.taojintianxia.cornucopia.shardingsphere.common.factory.YamlDataSourceFactory;
import com.github.taojintianxia.cornucopia.shardingsphere.common.util.JDBCUtil;
import lombok.SneakyThrows;

import javax.sql.DataSource;

/**
 * @author Nianjun Sun
 * @date 2020/4/14 21:29
 */
public class ShardingDatabaseDemo {

    @SneakyThrows
    public static void main(String... args) {
        DataSource dataSource = YamlDataSourceFactory.newInstance(ShardingType.SHARDING_DATABASES);
        JDBCUtil.initData(dataSource);
        JDBCUtil.execute(dataSource, SQLConstant.INSERT_TABLE_ORDER_ITEM_1);
        JDBCUtil.execute(dataSource, SQLConstant.INSERT_TABLE_ORDER_ITEM_2);
        JDBCUtil.execute(dataSource, SQLConstant.INSERT_TABLE_ORDER_ITEM_3);
        JDBCUtil.execute(dataSource, SQLConstant.INSERT_TABLE_ORDER_ITEM_4);
    }
}
