package com.github.taojintianxia.cornucopia.apollo.configsync.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nianjun Sun
 * @date 2019/11/21 18:11
 */
@Data
@Configuration
public class GitConfig {

    @Value("${git.repository:}")
    private String repository;
}
