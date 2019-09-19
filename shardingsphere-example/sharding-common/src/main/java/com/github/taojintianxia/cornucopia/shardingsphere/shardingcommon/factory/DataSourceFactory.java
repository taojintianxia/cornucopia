package com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.factory;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author Nianjun Sun
 * @date 2019/9/19 17:05
 */
public class DataSourceFactory {

    public static DataSource newInstance(final ShardingType shardingType) throws SQLException {
        switch (shardingType) {
            case SHARDING_DATABASES:
                return new ShardingDatabasesConfigurationPrecise().getDataSource();
            case SHARDING_TABLES:
                return new ShardingTablesConfigurationPrecise().getDataSource();
            case SHARDING_DATABASES_AND_TABLES:
                return new ShardingDatabasesAndTablesConfigurationPrecise().getDataSource();
            case MASTER_SLAVE:
                return new MasterSlaveConfiguration().getDataSource();
            case SHARDING_MASTER_SLAVE:
                return new ShardingMasterSlaveConfigurationPrecise().getDataSource();
            default:
                throw new UnsupportedOperationException(shardingType.name());
        }
    }
}
