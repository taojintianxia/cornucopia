package com.github.taojintianxia.consensus.ratis.databasereplicated.client.configuration;

import lombok.Data;

import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2020/5/18 13:57
 */
@Data
public class ClientYamlConfiguration {

    private List<String> peers;
}
