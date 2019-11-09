package com.github.taojintianxia.cornucopia.apollo.springboot.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nianjun Sun
 * @date 2019/9/5 13:08
 */
@Data
@Configuration
public class TestConfig {
    
    @Value("${test.key:defaultKey}")
    private String testKey;

    @Value("${test.value:defaultValue}")
    private String testValue;
}
