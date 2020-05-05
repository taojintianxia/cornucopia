package com.github.taojintianxia.consensus.ratis.mysqlreplicated.server;

import com.github.taojintianxia.consensus.ratis.mysqlreplicated.MySQLReplicatedStateMachine;
import com.github.taojintianxia.consensus.ratis.mysqlreplicated.constant.ParamConstant;
import com.github.taojintianxia.consensus.ratis.mysqlreplicated.util.JVMParamUtil;
import org.apache.ratis.conf.RaftProperties;
import org.apache.ratis.examples.arithmetic.ArithmeticStateMachine;
import org.apache.ratis.grpc.GrpcConfigKeys;
import org.apache.ratis.protocol.RaftGroup;
import org.apache.ratis.protocol.RaftGroupId;
import org.apache.ratis.protocol.RaftPeer;
import org.apache.ratis.protocol.RaftPeerId;
import org.apache.ratis.server.RaftServer;
import org.apache.ratis.server.RaftServerConfigKeys;
import org.apache.ratis.statemachine.StateMachine;
import org.apache.ratis.thirdparty.com.google.protobuf.ByteString;
import org.apache.ratis.util.LifeCycle;
import org.apache.ratis.util.NetUtils;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.rmi.server.ExportException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author Nianjun Sun
 * @date 2020/5/5 12:36
 */
public class MySQLReplicatedServer implements RatisServer {

    @Override
    public void run() throws Exception {
        RaftPeerId raftPeerId = RaftPeerId.valueOf(JVMParamUtil.getParamFromJVM(ParamConstant.ID));
        RaftPeer raftPeer = getPeer(raftPeerId);
        String raftGroupId = "raftGroup-" + new Random().nextInt(100);
        RaftProperties properties = new RaftProperties();
        final int port = NetUtils.createSocketAddr(getPeer(raftPeerId).getAddress()).getPort();
        GrpcConfigKeys.Server.setPort(properties, port);
        properties.setInt(GrpcConfigKeys.OutputStream.RETRY_TIMES_KEY, Integer.MAX_VALUE);
        File StorageDir = new File(JVMParamUtil.getParamFromJVM(ParamConstant.STORAGE));
        RaftServerConfigKeys.setStorageDirs(properties, Collections.singletonList(StorageDir));
        StateMachine stateMachine = new MySQLReplicatedStateMachine();

        final RaftGroup raftGroup = RaftGroup.valueOf(RaftGroupId.valueOf(ByteString.copyFromUtf8(raftGroupId)),
                getPeer(raftPeerId));
        RaftServer raftServer = RaftServer.newBuilder()
                .setServerId(raftPeerId)
                .setStateMachine(stateMachine).setProperties(properties)
                .setGroup(raftGroup)
                .build();
        raftServer.start();

        for (; raftServer.getLifeCycleState() != LifeCycle.State.CLOSED; ) {
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public RaftPeer getPeer(RaftPeerId raftPeerId) {
        Objects.requireNonNull(raftPeerId, "raftPeerId == null");
        for (RaftPeer p : parsePeers(JVMParamUtil.getParamFromJVM(ParamConstant.PEERS))) {
            if (raftPeerId.equals(p.getId())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Raft peer id " + raftPeerId + " is not part of the raft group definitions ");
    }

    public RaftPeer[] parsePeers(String peers) {
        return Stream.of(peers.split(",")).map(address -> {
            String[] addressParts = address.split(":");
            return new RaftPeer(RaftPeerId.valueOf(addressParts[0]),
                    addressParts[1] + ":" + addressParts[2]);
        }).toArray(RaftPeer[]::new);
    }

}
