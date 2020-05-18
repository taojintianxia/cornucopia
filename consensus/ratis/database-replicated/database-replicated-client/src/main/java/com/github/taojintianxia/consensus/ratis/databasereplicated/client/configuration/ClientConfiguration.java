package com.github.taojintianxia.consensus.ratis.databasereplicated.client.configuration;

import lombok.Data;
import lombok.SneakyThrows;
import org.apache.ratis.protocol.RaftGroup;
import org.apache.ratis.protocol.RaftGroupId;
import org.apache.ratis.protocol.RaftPeer;
import org.apache.ratis.protocol.RaftPeerId;
import org.apache.ratis.thirdparty.com.google.protobuf.ByteString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2020/5/18 15:27
 */
@Data
public class ClientConfiguration {

    private List<RaftPeer> raftPeers;

    private RaftGroup raftGroup;

    public List<RaftPeer> parsePeers(List<String> peers) {
        List<RaftPeer> raftPeers = new ArrayList<>(peers.size());
        peers.forEach(address -> {
            String[] addressParts = address.split(":");
            raftPeers.add(new RaftPeer(RaftPeerId.valueOf(addressParts[0]), addressParts[1] + ":" + addressParts[2]));
        });

        return raftPeers;
    }

    @SneakyThrows
    public ClientConfiguration swap(ClientYamlConfiguration clientYamlConfiguration) {
        this.raftPeers = parsePeers(clientYamlConfiguration.getPeers());
        this.raftGroup = RaftGroup.valueOf(RaftGroupId.valueOf(ByteString.copyFromUtf8(clientYamlConfiguration.getRaftGroupId())), raftPeers);
        return this;
    }
}
