package com.github.taojintianxia.cornucopia.jdbctest.statement;

import com.github.taojintianxia.cornucopia.jdbctest.ShardingJDBCApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

public class ReadWriteBenchmark implements SysbenchBenchmark {

    private Connection connection;

    private PreparedStatement pointSelectStatement;

    private PreparedStatement updateIndexStatement;

    private PreparedStatement updateNonIndexStatement;

    private PreparedStatement deleteStatement;

    private PreparedStatement insertStatement;

    @Override
    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
        pointSelectStatement = connection.prepareStatement("select c from sbtest1 where id = ?");
        updateIndexStatement = connection.prepareStatement("UPDATE sbtest1 SET k=k+1 WHERE id=?");
        updateNonIndexStatement = connection.prepareStatement("UPDATE sbtest1 SET c=? WHERE id=?");
        deleteStatement = connection.prepareStatement("DELETE FROM sbtest1 WHERE id=?");
        insertStatement = connection.prepareStatement("INSERT INTO sbtest1 (id, k, c, pad) VALUES (?, ?, ?, ?)");
    }


    @Override
    public void execute() throws SQLException {
        connection.setAutoCommit(false);
        int randomId = ThreadLocalRandom.current().nextInt(ShardingJDBCApplication.TABLE_SIZE);
        pointSelectStatement.setInt(1, randomId);
        pointSelectStatement.execute();
        updateIndexStatement.setInt(1, randomId);
        updateIndexStatement.execute();
        updateNonIndexStatement.setString(1, String.valueOf(randomId));
        updateNonIndexStatement.setInt(2, randomId);
        updateNonIndexStatement.execute();
        deleteStatement.setInt(1, randomId);
        deleteStatement.execute();
        insertStatement.setInt(1, randomId);
        insertStatement.setInt(2, ThreadLocalRandom.current().nextInt());
        insertStatement.setString(3, String.valueOf(randomId));
        insertStatement.setString(4, String.valueOf(randomId));
        insertStatement.execute();
        connection.commit();

    }
}
