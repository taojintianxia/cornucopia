package com.github.taojintianxia.consensus.ratis.mysqlreplicated.client;

import java.io.IOException;

/**
 * @author Nianjun Sun
 * @date 2020/5/7 08:52
 */
public interface RatisClient {

    void run () throws IOException;
}
