package com.github.taojintianxia.consensus.ratis.databasereplicated.server.util;

import com.github.taojintianxia.consensus.ratis.databasereplicated.server.configuration.ServerYamlConfiguration;
import com.github.taojintianxia.consensus.ratis.databasereplicated.server.constant.ServerConstant;
import com.google.common.io.Resources;
import lombok.SneakyThrows;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author Nianjun Sun
 * @date 2020/5/18 18:38
 */
public class ServerConfigurationUtil {

    @SneakyThrows
    public static ServerYamlConfiguration loadClientYamlConfiguration() {
        try (InputStream inputStream = new FileInputStream(
                Resources.getResource(ServerConstant.SERVER_YAML_CONFIG_PATH).getFile())) {
            return new Yaml().loadAs(inputStream, ServerYamlConfiguration.class);
        }
    }
}
