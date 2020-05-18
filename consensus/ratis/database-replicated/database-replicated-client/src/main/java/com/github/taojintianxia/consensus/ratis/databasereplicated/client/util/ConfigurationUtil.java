package com.github.taojintianxia.consensus.ratis.databasereplicated.client.util;

import com.github.taojintianxia.consensus.ratis.databasereplicated.client.configuration.ClientYamlConfiguration;
import com.github.taojintianxia.consensus.ratis.databasereplicated.client.constant.ClientConstant;
import lombok.SneakyThrows;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author Nianjun Sun
 * @date 2020/5/18 18:38
 */
public class ConfigurationUtil {

    @SneakyThrows
    public static ClientYamlConfiguration loadClientYamlConfiguration() {
        InputStream inputStream = new FileInputStream(ClientConstant.CLIENT_YAML_CONFIG_PATH);
        return new Yaml().loadAs(inputStream, ClientYamlConfiguration.class);
    }
}
