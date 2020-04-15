package com.github.taojintianxia.conuporpia.shardingsphere.shardingcore.rawjdbc.masterslave;

import com.github.taojintianxia.cornucopia.shardingsphere.common.constant.SQLConstant;
import com.github.taojintianxia.cornucopia.shardingsphere.common.enums.ShardingType;
import com.github.taojintianxia.cornucopia.shardingsphere.common.factory.YamlDataSourceFactory;
import com.github.taojintianxia.cornucopia.shardingsphere.common.util.JDBCUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author Nianjun Sun
 * @date 2020/4/9 22:49
 */
@Slf4j
public class MasterSlaveDemo {

    private static final String SQL = "SELECT i.* FROM t_order o JOIN t_order_item i ON o.order_id=i.order_id WHERE o.user_id=? AND o.order_id=?";

    private static Connection connection;

    @SneakyThrows
    public static void main(String... args) {
        DataSource dataSource = YamlDataSourceFactory.newInstance(ShardingType.MASTER_SLAVE);
        JDBCUtil.initData(dataSource);
        testCURD(dataSource);
    }

    public static void testCURD(DataSource dataSource) {
        JDBCUtil.execute(dataSource, SQLConstant.INSERT_TABLE_ORDER);
    }
}