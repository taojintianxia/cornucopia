package com.github.taojintianxia.cornucopia.shardingsphere.common.configuration;

import javax.sql.DataSource;

/**
 * @author Nianjun Sun
 * @date 2019/10/15 16:33
 */
public interface CommonConfiguration {

    /**
     * get datasource
     *
     * @return
     */
    DataSource getDataSource();
}
