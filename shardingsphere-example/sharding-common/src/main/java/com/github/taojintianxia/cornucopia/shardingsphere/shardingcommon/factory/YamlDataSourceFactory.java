package com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.factory;

import com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.enums.ShardingType;
import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlMasterSlaveDataSourceFactory;
import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Nianjun Sun
 * @date 2019/9/19 17:19
 */
public class YamlDataSourceFactory {

    public static DataSource newInstance(final ShardingType shardingType) throws SQLException, IOException {
        switch (shardingType) {
            case SHARDING_DATABASES:
                return YamlShardingDataSourceFactory.createDataSource(getFile("/META-INF/sharding-databases.yaml"));
            case SHARDING_TABLES:
                return YamlShardingDataSourceFactory.createDataSource(getFile("/META-INF/sharding-tables.yaml"));
            case SHARDING_DATABASES_AND_TABLES:
                return YamlShardingDataSourceFactory
                        .createDataSource(getFile("/META-INF/sharding-databases-tables.yaml"));
            case MASTER_SLAVE:
                return YamlMasterSlaveDataSourceFactory.createDataSource(getFile("/META-INF/master-slave.yaml"));
            case SHARDING_MASTER_SLAVE:
                return YamlShardingDataSourceFactory.createDataSource(getFile("/META-INF/sharding-master-slave.yaml"));
            default:
                throw new UnsupportedOperationException(shardingType.name());
        }
    }

    private static File getFile(final String fileName) {
        return new File(Thread.currentThread().getClass().getResource(fileName).getFile());
    }
}
