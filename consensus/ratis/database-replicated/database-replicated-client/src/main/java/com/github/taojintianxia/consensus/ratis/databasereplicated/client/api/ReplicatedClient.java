package com.github.taojintianxia.consensus.ratis.databasereplicated.client.api;

/**
 * @author Nianjun Sun
 * @date 2020/5/18 13:02
 */
public interface ReplicatedClient {

    long execute(String sql);
}
