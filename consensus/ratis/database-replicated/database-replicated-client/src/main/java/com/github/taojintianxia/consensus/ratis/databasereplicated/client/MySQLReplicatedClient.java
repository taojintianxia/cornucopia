package com.github.taojintianxia.consensus.ratis.databasereplicated.client;

import com.github.taojintianxia.consensus.ratis.databasereplicated.client.api.ReplicatedClient;

import java.io.IOException;

/**
 * @author Nianjun Sun
 * @date 2020/5/6 14:45
 */
public class MySQLReplicatedClient implements ReplicatedClient {

    @Override
    public long execute(String sql) throws IOException {
//        String raftGroupId = "demoRaftGroup123";
//        RaftProperties raftProperties = new RaftProperties();
//        final RaftGroup raftGroup = RaftGroup
//                .valueOf(RaftGroupId.valueOf(ByteString.copyFromUtf8(raftGroupId)), JVMParamUtil.getPeers());
//
//        RaftClient.Builder builder = RaftClient.newBuilder().setProperties(raftProperties);
//        builder.setRaftGroup(raftGroup);
//        builder.setClientRpc(new GrpcFactory(new Parameters()).newRaftClientRpc(ClientId.randomId(), raftProperties));
//        RaftClient client = builder.build();
//        SQLMessage sqlMessage = new SQLMessage(sql);
//        client.send(sqlMessage);
        return 1L;
    }
}
