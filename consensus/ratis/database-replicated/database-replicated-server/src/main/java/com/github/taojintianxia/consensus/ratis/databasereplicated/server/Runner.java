package com.github.taojintianxia.consensus.ratis.databasereplicated.server;

import com.github.taojintianxia.consensus.ratis.databasereplicated.server.api.ReplicatedServer;

/**
 * @author Nianjun Sun
 * @date 2020/5/18 13:01
 */
public class Runner {

    public static void main(String... args) throws Exception {
        ReplicatedServer ratisServer = new MySQLReplicatedServer();
        ratisServer.execute();
    }
}
