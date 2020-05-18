package com.github.taojintianxia.consensus.ratis.databasereplicated.client;

import com.github.taojintianxia.consensus.ratis.databasereplicated.client.api.ReplicatedClient;
import com.github.taojintianxia.consensus.ratis.databasereplicated.client.configuration.ClientConfiguration;
import com.github.taojintianxia.consensus.ratis.databasereplicated.client.util.ConfigurationUtil;
import com.github.taojintianxia.consensus.ratis.databasereplicated.common.message.SQLMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.ratis.client.RaftClient;
import org.apache.ratis.conf.Parameters;
import org.apache.ratis.conf.RaftProperties;
import org.apache.ratis.grpc.GrpcFactory;
import org.apache.ratis.protocol.ClientId;
import org.apache.ratis.protocol.RaftClientReply;

import java.io.IOException;

/**
 * @author Nianjun Sun
 * @date 2020/5/6 14:45
 */
@Slf4j
public class MySQLReplicatedClient implements ReplicatedClient {

    @Override
    public long execute(String sql) throws IOException {
        ClientConfiguration clientConfiguration = new ClientConfiguration()
                .swap(ConfigurationUtil.loadClientYamlConfiguration());
        RaftProperties raftProperties = new RaftProperties();
        RaftClient.Builder builder = RaftClient.newBuilder().setProperties(raftProperties);
        builder.setRaftGroup(clientConfiguration.getRaftGroup());
        builder.setClientRpc(new GrpcFactory(new Parameters()).newRaftClientRpc(ClientId.randomId(), raftProperties));
        RaftClient client = builder.build();
        SQLMessage sqlMessage = new SQLMessage(sql);
        RaftClientReply raftClientReply = client.send(sqlMessage);
        log.info("raft group response : " + raftClientReply.getMessage().getContent().toString());
        return 1L;
    }
}
