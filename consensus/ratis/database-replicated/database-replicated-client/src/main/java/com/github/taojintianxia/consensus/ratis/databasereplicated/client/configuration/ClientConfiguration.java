package com.github.taojintianxia.consensus.ratis.databasereplicated.client.configuration;

import lombok.Data;
import lombok.SneakyThrows;
import org.apache.ratis.protocol.RaftPeer;
import org.apache.ratis.protocol.RaftPeerId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Nianjun Sun
 * @date 2020/5/18 15:27
 */
@Data
public class ClientConfiguration {

    private List<RaftPeer> raftPeers;

    public static RaftPeer[] parsePeers(String peers) {
        return Stream.of(peers.split(",")).map(address -> {
            String[] addressParts = address.split(":");
            return new RaftPeer(RaftPeerId.valueOf(addressParts[0]), addressParts[1] + ":" + addressParts[2]);
        }).toArray(RaftPeer[]::new);
    }

    @SneakyThrows
    public ClientConfiguration swap(ClientYamlConfiguration clientYamlConfiguration) {
        List<String> peers = clientYamlConfiguration.getPeers();
        List<RaftPeer> raftPeers = new ArrayList<>(peers.size());
        peers.forEach(address -> {
            String[] addressParts = address.split(":");
            raftPeers.add(new RaftPeer(RaftPeerId.valueOf(addressParts[0]), addressParts[1] + ":" + addressParts[2]));
        });
        this.raftPeers = raftPeers;
        return this;
    }
}
