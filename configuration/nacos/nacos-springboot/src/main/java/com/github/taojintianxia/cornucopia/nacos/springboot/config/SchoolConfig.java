package com.github.taojintianxia.cornucopia.nacos.springboot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nianjun Sun
 * @date 2019-08-20 18:51
 */
@Data
@Configuration
public class SchoolConfig {

    /**
     * 学校面积
     */
    @Value("${school.area:50}")
    private double area;

    /**
     * 学校等级
     */
    @Value("${school.level:}")
    private String level;
}
