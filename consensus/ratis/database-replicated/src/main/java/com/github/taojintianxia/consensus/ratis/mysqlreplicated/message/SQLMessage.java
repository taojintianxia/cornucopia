package com.github.taojintianxia.consensus.ratis.mysqlreplicated.message;

import org.apache.ratis.protocol.Message;
import org.apache.ratis.thirdparty.com.google.protobuf.ByteString;
import org.apache.ratis.util.ProtoUtils;

/**
 * @author Nianjun Sun
 * @date 2020/5/6 16:00
 */
public class SQLMessage implements Message {

    public SQLMessage(String sql) {
        this.sql = sql;
    }

    private String sql;

    @Override
    public ByteString getContent() {
        return ProtoUtils.toByteString(sql);
    }
}
