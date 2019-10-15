package com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.factory;

import com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.enums.ShardingType;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author Nianjun Sun
 * @date 2019/9/19 17:05
 */
public class DataSourceFactory {

    public static DataSource newInstance(final ShardingType shardingType) throws SQLException {
        switch (shardingType) {
            case SHARDING_MASTER_SLAVE:
                return new ShardingMasterSlaveConfigurationPrecise().getDataSource();
            default:
                throw new UnsupportedOperationException(shardingType.name());
        }
    }
}
