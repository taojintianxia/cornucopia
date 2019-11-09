package com.github.taojintianxia.cornucopia.apollo.springboot.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nianjun Sun
 * @date 2019/11/9 11:10
 */
@Data
@Configuration
public class CommonConfig {

    @Value("${common.commonName:defaultName}")
    private String name;

    @Value("${common.commonConfigCenter:defaultConfigCenter}")
    private String configCenterName;

    @Value("${dataSource.driverClassName:defaultDriver}")
    private String driverClassName;

    @Value("${dataSource.jdbcUrl:defaultJdbcURL}")
    private String jdbcUrl;
}
