package com.github.taojintianxia.consensus.ratis.mysqlreplicated;

import com.github.taojintianxia.consensus.ratis.mysqlreplicated.client.MySQLReplicatedClient;
import com.github.taojintianxia.consensus.ratis.mysqlreplicated.client.RatisClient;

import java.io.IOException;

/**
 * @author Nianjun Sun
 * @date 2020/5/7 09:23
 */
public class ClientRunner {

    public static void main(String...args) throws IOException {
        RatisClient ratisClient = new MySQLReplicatedClient();
        ratisClient.run();
    }
}
