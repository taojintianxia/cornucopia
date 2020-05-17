package com.github.taojintianxia.consensus.ratis.databaseraplicated.util;

import com.github.taojintianxia.consensus.ratis.databaseraplicated.constant.ParamConstant;
import org.apache.ratis.protocol.RaftPeer;
import org.apache.ratis.protocol.RaftPeerId;

import java.lang.management.ManagementFactory;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Nianjun Sun
 * @date 2020/5/5 12:42
 */
public class JVMParamUtil {

    public static String getParamFromJVM(String key) {
        return ManagementFactory.getRuntimeMXBean().getSystemProperties().get(key);
    }

    public static RaftPeer getPeer(RaftPeerId raftPeerId) {
        Objects.requireNonNull(raftPeerId, "raftPeerId == null");
        for (RaftPeer p : parsePeers(getParamFromJVM(ParamConstant.PEERS))) {
            if (raftPeerId.equals(p.getId())) {
                return p;
            }
        }
        throw new IllegalArgumentException(
                "Raft peer id " + raftPeerId + " is not part of the raft group definitions ");
    }

    public static RaftPeer[] getPeers(){
        return parsePeers(getParamFromJVM(ParamConstant.PEERS));
    }

    private static RaftPeer[] parsePeers(String peers) {
        return Stream.of(peers.split(",")).map(address -> {
            String[] addressParts = address.split(":");
            return new RaftPeer(RaftPeerId.valueOf(addressParts[0]), addressParts[1] + ":" + addressParts[2]);
        }).toArray(RaftPeer[]::new);
    }
}
