package com.github.taojintianxia.consensus.ratis.databasereplicated.client.util;

import com.github.taojintianxia.consensus.ratis.databasereplicated.client.configuration.ClientYamlConfiguration;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * @author Nianjun Sun
 * @date 2020/5/18 18:47
 */

public class ClientConfigurationUtilTest {

    @Test
    public void testLoadClientYamlConfiguration() {
        ClientYamlConfiguration clientYamlConfiguration = ClientConfigurationUtil.loadClientYamlConfiguration();
        assertNotNull("clientYamlConfiguration should not be null", clientYamlConfiguration);
        assertFalse("peers should not be empty", clientYamlConfiguration.getPeers().isEmpty());
    }
}
