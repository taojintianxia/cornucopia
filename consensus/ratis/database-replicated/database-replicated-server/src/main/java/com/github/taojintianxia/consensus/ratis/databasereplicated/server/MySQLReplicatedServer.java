package com.github.taojintianxia.consensus.ratis.databasereplicated.server;

import com.github.taojintianxia.consensus.ratis.databasereplicated.server.api.ReplicatedServer;

import java.io.IOException;

/**
 * @author Nianjun Sun
 * @date 2020/5/5 12:36
 */
public class MySQLReplicatedServer implements ReplicatedServer {

    @Override
    public void execute() throws IOException {
//        RaftPeerId raftPeerId = RaftPeerId.valueOf(JVMParamUtil.getParamFromJVM(ParamConstant.ID));
//        RaftPeer raftPeer = JVMParamUtil.getPeer(raftPeerId);
//        String raftGroupId = "demoRaftGroup123";
//        RaftProperties properties = new RaftProperties();
//        final int port = NetUtils.createSocketAddr(JVMParamUtil.getPeer(raftPeerId).getAddress()).getPort();
//        GrpcConfigKeys.Server.setPort(properties, port);
//        properties.setInt(GrpcConfigKeys.OutputStream.RETRY_TIMES_KEY, Integer.MAX_VALUE);
//        File StorageDir = new File(JVMParamUtil.getParamFromJVM(ParamConstant.STORAGE));
//        RaftServerConfigKeys.setStorageDirs(properties, Collections.singletonList(StorageDir));
//        StateMachine stateMachine = new MySQLReplicatedStateMachine();
//
//        final RaftGroup raftGroup = RaftGroup
//                .valueOf(RaftGroupId.valueOf(ByteString.copyFromUtf8(raftGroupId)), JVMParamUtil.getPeers());
//        RaftServer raftServer = RaftServer.newBuilder().setServerId(raftPeerId).setStateMachine(stateMachine)
//                .setProperties(properties).setGroup(raftGroup).build();
//        raftServer.start();
//
//        for (; raftServer.getLifeCycleState() != LifeCycle.State.CLOSED; ) {
//            TimeUnit.SECONDS.sleep(1);
//        }
    }
}
