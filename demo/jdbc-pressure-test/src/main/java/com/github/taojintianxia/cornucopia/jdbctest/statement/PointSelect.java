package com.github.taojintianxia.cornucopia.jdbctest.statement;

import com.github.taojintianxia.cornucopia.jdbctest.constants.SysbenchConstant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

public class PointSelect implements SysbenchBenchmark {

    private final Connection connection;

    private final PreparedStatement pointSelectStatement;

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public PointSelect( Connection connection ) throws SQLException {
        this.connection = connection;
        pointSelectStatement = connection.prepareStatement("SELECT c FROM sbtest1 WHERE id = ?");
    }

    @Override
    public void execute() throws SQLException {
        pointSelectStatement.setInt(1, random.nextInt(Integer.parseInt(SysbenchConstant.SYSBENCH_PARAM_MAP.get("table-size"))));
        pointSelectStatement.execute();
    }
}