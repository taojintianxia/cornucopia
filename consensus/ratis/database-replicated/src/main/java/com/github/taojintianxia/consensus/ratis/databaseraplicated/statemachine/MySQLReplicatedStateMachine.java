package com.github.taojintianxia.consensus.ratis.databaseraplicated.statemachine;

import com.github.taojintianxia.consensus.ratis.databaseraplicated.message.SQLMessage;
import org.apache.ratis.examples.arithmetic.expression.Expression;
import org.apache.ratis.proto.RaftProtos;
import org.apache.ratis.protocol.Message;
import org.apache.ratis.protocol.RaftGroupId;
import org.apache.ratis.server.RaftServer;
import org.apache.ratis.server.impl.RaftServerConstants;
import org.apache.ratis.server.protocol.TermIndex;
import org.apache.ratis.server.storage.RaftStorage;
import org.apache.ratis.statemachine.StateMachineStorage;
import org.apache.ratis.statemachine.TransactionContext;
import org.apache.ratis.statemachine.impl.SimpleStateMachineStorage;
import org.apache.ratis.statemachine.impl.SingleFileSnapshotInfo;
import org.apache.ratis.thirdparty.com.google.protobuf.ByteString;
import org.apache.ratis.util.AutoCloseableLock;
import org.apache.ratis.util.JavaUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Nianjun Sun
 * @date 2020/5/5 12:18
 */
public class MySQLReplicatedStateMachine extends BaseStateMachine {

    private final Map<String, Double> variables = new ConcurrentHashMap<>();

    private final SimpleStateMachineStorage storage = new SimpleStateMachineStorage();

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    private AutoCloseableLock readLock() {
        return AutoCloseableLock.acquire(lock.readLock());
    }

    private AutoCloseableLock writeLock() {
        return AutoCloseableLock.acquire(lock.writeLock());
    }

    void reset() {
        variables.clear();
        setLastAppliedTermIndex(null);
    }

    @Override
    public void initialize(RaftServer server, RaftGroupId groupId,
                           RaftStorage raftStorage) throws IOException {
        super.initialize(server, groupId, raftStorage);
        this.storage.init(raftStorage);
        loadSnapshot(storage.getLatestSnapshot());
    }

    @Override
    public void reinitialize() throws IOException {
        close();
        loadSnapshot(storage.getLatestSnapshot());
    }

    @Override
    public long takeSnapshot() {
        final Map<String, Double> copy;
        final TermIndex last;
        try(AutoCloseableLock readLock = readLock()) {
            copy = new HashMap<>(variables);
            last = getLastAppliedTermIndex();
        }

        final File snapshotFile =  storage.getSnapshotFile(last.getTerm(), last.getIndex());
        LOG.info("Taking a snapshot to file {}", snapshotFile);

        try(ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(snapshotFile)))) {
            out.writeObject(copy);
        } catch(IOException ioe) {
            LOG.warn("Failed to write snapshot file \"" + snapshotFile
                    + "\", last applied index=" + last);
        }

        return last.getIndex();
    }

    public long loadSnapshot(SingleFileSnapshotInfo snapshot) throws IOException {
        return load(snapshot, false);
    }

    private long load(SingleFileSnapshotInfo snapshot, boolean reload) throws IOException {
        if (snapshot == null) {
            LOG.warn("The snapshot info is null.");
            return RaftServerConstants.INVALID_LOG_INDEX;
        }
        final File snapshotFile = snapshot.getFile().getPath().toFile();
        if (!snapshotFile.exists()) {
            LOG.warn("The snapshot file {} does not exist for snapshot {}", snapshotFile, snapshot);
            return RaftServerConstants.INVALID_LOG_INDEX;
        }

        final TermIndex last = SimpleStateMachineStorage.getTermIndexFromSnapshotFile(snapshotFile);
        try(AutoCloseableLock writeLock = writeLock();
            ObjectInputStream in = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream(snapshotFile)))) {
            if (reload) {
                reset();
            }
            setLastAppliedTermIndex(last);
            variables.putAll(JavaUtils.cast(in.readObject()));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        return last.getIndex();
    }

    @Override
    public StateMachineStorage getStateMachineStorage() {
        return storage;
    }

    @Override
    public CompletableFuture<Message> query(Message request) {
        final Expression q = Expression.Utils.bytes2Expression(request.getContent().toByteArray(), 0);
        final Double result;
        try(AutoCloseableLock readLock = readLock()) {
            result = q.evaluate(variables);
        }
        final Expression r = Expression.Utils.double2Expression(result);
        LOG.debug("QUERY: {} = {}", q, r);
        return CompletableFuture.completedFuture(Expression.Utils.toMessage(r));
    }

    @Override
    public void close() {
        reset();
    }

    @Override
    public CompletableFuture<Message> applyTransaction(TransactionContext trx) {
        final RaftProtos.LogEntryProto entry = trx.getLogEntry();
        ByteString byteString = entry.getStateMachineLogEntry().getLogData();
        final SQLMessage sqlMessage = new SQLMessage(byteString.toStringUtf8());
        System.out.println(byteString.toStringUtf8());

        final long index = entry.getIndex();
        final Double result = 0D;
        try(AutoCloseableLock writeLock = writeLock()) {
            updateLastAppliedTermIndex(entry.getTerm(), index);
        }
        final Expression r = Expression.Utils.double2Expression(result);
        final CompletableFuture<Message> f = CompletableFuture.completedFuture(Expression.Utils.toMessage(r));

        final RaftProtos.RaftPeerRole role = trx.getServerRole();
//        if (role == RaftProtos.RaftPeerRole.LEADER) {
//            LOG.info("{}:{}-{}: {} = {}", role, getId(), index, assignment, r);
//        } else {
//            LOG.debug("{}:{}-{}: {} = {}", role, getId(), index, assignment, r);
//        }
//        if (LOG.isTraceEnabled()) {
//            LOG.trace("{}-{}: variables={}", getId(), index, variables);
//        }
        return f;
    }
}
