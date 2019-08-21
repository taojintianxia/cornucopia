package com.github.taojintianxia.nacos.springboot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nianjun Sun
 * @date 2019-08-21 10:17
 */
@Data
@RefreshScope
@Configuration
public class DynamicSchoolConfig {

    @Value("${school.principal}")
    private String principal;

    @Value("${school.location}")
    private String location;
}
