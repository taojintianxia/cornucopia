package com.github.taojintianxia.cornucopia.databasebenchmark.model;

import com.github.taojintianxia.cornucopia.databasebenchmark.EnvironmentContext;
import com.github.taojintianxia.cornucopia.databasebenchmark.GlobalCounter;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class PointSelect implements ModelScript {

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
        System.out.println("---xx--------");
        return tableSizeRandom.nextInt(tableSize);
    }

    @Override
    public void execute( PreparedStatement statement ) throws SQLException {
        statement.setLong(1, tableSizeRandom.nextLong());
        statement.executeQuery();
        GlobalCounter.getInstance().plus();
    }

    public String getSql() {
        return "select c from sbtest%d where id = ?".replace("%d", Math.abs(tableRandom.nextInt(table)) + "");
    }
}
