package com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.configuration.masterslave;

import com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.configuration.CommonConfiguration;

import javax.sql.DataSource;

/**
 * @author Nianjun Sun
 * @date 2019/10/15 16:34
 */
public class SimpleMasterSlaveConfiguration implements CommonConfiguration
{
    @Override
    public DataSource getDataSource() {
        return null;
    }
}
