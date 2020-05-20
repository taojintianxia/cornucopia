package com.github.taojintianxia.consensus.ratis.databasereplicated.server.configuration;

import lombok.Data;

import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2020/5/18 13:57
 */
@Data
public class ServerYamlConfiguration {

    private List<String> peers;

    private String raftGroupId;
}
