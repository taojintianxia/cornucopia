package com.github.taojintianxia.consensus.ratis.databasereplicated.client;

import com.github.taojintianxia.consensus.ratis.databasereplicated.client.api.ReplicatedClient;

import java.io.IOException;

/**
 * @author Nianjun Sun
 * @date 2020/5/18 13:01
 */
public class Runner {

    public static void main(String... args) throws IOException {
        ReplicatedClient ratisClient = new MySQLReplicatedClient();
        String sql = "INSERT INTO t_order(order_id,user_id,address_id,status) VALUES(1, 1, 1, 'INIT')";
        ratisClient.execute(sql);
    }
}
