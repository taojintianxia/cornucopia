package com.github.taojintianxia.cornucopia.apollo.configsync.controller;


import com.github.taojintianxia.cornucopia.apollo.configsync.config.DockerConfig;
import com.github.taojintianxia.cornucopia.apollo.configsync.config.GitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nianjun Sun
 * @date 2019/11/21 14:54
 */
@RestController
public class ConfigSyncController {

    @Autowired
    private DockerConfig dockerConfig;

    @Autowired
    private GitConfig gitConfig;

    @GetMapping("/config_sync/getDockerConfig")
    public String getDockerConfig() {
        return String.format("docker host is : %s, docker cert path is : %s", dockerConfig.getHost(),
                dockerConfig.getCertPath());
    }

    @GetMapping("/config_sync/getGitConfig")
    public String getGitConfig() {
        return String.format("git repository is : %s", gitConfig.getRepository());
    }
}
