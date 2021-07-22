package com.github.taojintianxia.cornucopia.databasebenchmark.model;

import com.github.taojintianxia.cornucopia.databasebenchmark.connection.PointSelectConnection;
import com.github.taojintianxia.cornucopia.databasebenchmark.context.EnvironmentContext;
import com.github.taojintianxia.cornucopia.databasebenchmark.analysis.GlobalCounter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class PointSelect implements ModelScript<List<PreparedStatement>> {

    private final int tableSize;

    private final int table;

    private final Random tableSizeRandom;

    private final Random tableRandom;

    public PointSelect() {
        tableSize = Integer.parseInt((EnvironmentContext.getInstance().getBenchmarkMap().get("tableSize")));
        table = Integer.parseInt(EnvironmentContext.getInstance().getBenchmarkMap().get("table"));
        tableSizeRandom = new Random();
        tableRandom = new Random();
    }

    @Override
    public long getId() {
        return tableSizeRandom.nextInt(tableSize);
    }

    @Override
    public void execute( List<PreparedStatement> statements ) throws SQLException {
        PreparedStatement preparedStatement = statements.get(tableRandom.nextInt(table));
        preparedStatement.setLong(1, tableSizeRandom.nextLong());
        preparedStatement.executeQuery();
        GlobalCounter.getInstance().plus();
    }

    public String getSql() {
        return "select c from sbtest%d where id = ?";
    }
}
