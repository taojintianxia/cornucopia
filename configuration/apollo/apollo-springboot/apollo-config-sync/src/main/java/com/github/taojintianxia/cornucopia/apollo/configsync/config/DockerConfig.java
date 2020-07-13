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
public class DockerConfig {

    @Value("${docker.host:}")
    private String host;

    @Value("${docker.repository.host:}")
    private String repositoryHost;

    @Value("${docker.certPath:/etc/docker}")
    private String certPath;
}
