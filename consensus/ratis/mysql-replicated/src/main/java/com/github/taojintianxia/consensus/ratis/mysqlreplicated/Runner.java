package com.github.taojintianxia.consensus.ratis.mysqlreplicated;

import com.github.taojintianxia.consensus.ratis.mysqlreplicated.server.MySQLReplicatedServer;
import com.github.taojintianxia.consensus.ratis.mysqlreplicated.server.RatisServer;

/**
 * @author Nianjun Sun
 * @date 2020/5/5 17:08
 */
public class Runner {

    public static void main(String... args) throws Exception {
        RatisServer ratisServer = new MySQLReplicatedServer();
        ratisServer.run();
    }
}
