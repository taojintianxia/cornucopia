package com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave;

import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlMasterSlaveDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;

/**
 * @author Nianjun Sun
 * @date 2019/9/2 10:27
 */
public class MasterSlaveApplication {

    public static void main(String... args) throws Exception {
        DataSource dataSource = YamlMasterSlaveDataSourceFactory.createDataSource(new File(""));
    }

}
