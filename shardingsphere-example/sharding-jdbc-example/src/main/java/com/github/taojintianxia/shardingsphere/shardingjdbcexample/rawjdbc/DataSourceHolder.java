package com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc;

import javax.sql.DataSource;

/**
 * @author Nianjun Sun
 * @date 2019/10/15 19:25
 */
public interface DataSourceHolder {

    /**
     * get datasource
     *
     * @return
     */
    DataSource getDataSource();

    /**
     * set datasource
     *
     * @param datasource
     */
    void setDataSource(DataSource datasource);
}
