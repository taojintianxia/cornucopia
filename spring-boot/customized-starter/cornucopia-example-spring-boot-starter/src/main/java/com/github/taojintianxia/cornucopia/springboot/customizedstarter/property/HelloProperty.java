package com.github.taojintianxia.cornucopia.springboot.customizedstarter.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Nianjun Sun
 * @date 2020/3/9 16:36
 */
@Data
@ConfigurationProperties(prefix = "sayhello")
public class HelloProperty {

    public static final String DEFAULT_TARGET = "world";

    private String target = DEFAULT_TARGET;
}
