package com.github.taojintianxia.conuporpia.shardingsphere.shardingcore.rawjdbc.masterslave;

import com.github.taojintianxia.cornucopia.shardingsphere.common.enums.ShardingType;
import com.github.taojintianxia.cornucopia.shardingsphere.common.factory.YamlDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
/**
 * @author Nianjun Sun
 * @date 2020/4/9 22:49
 */
public class MasterSlaveDemo {


    public static void main(String... args) {
        try {
            DataSource dataSource = YamlDataSourceFactory.newInstance(ShardingType.MASTER_SLAVE);
        } catch (SQLException | IOException e) {

        }
    }
}
