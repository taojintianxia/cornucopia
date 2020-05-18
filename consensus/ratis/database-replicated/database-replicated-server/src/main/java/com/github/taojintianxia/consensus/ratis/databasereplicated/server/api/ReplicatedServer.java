package com.github.taojintianxia.consensus.ratis.databasereplicated.server.api;

import java.io.IOException;

/**
 * @author Nianjun Sun
 * @date 2020/5/18 13:03
 */
public interface ReplicatedServer {

    void execute() throws IOException;
}
