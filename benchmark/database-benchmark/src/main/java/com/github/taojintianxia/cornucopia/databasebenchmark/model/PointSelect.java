package com.github.taojintianxia.cornucopia.databasebenchmark.model;

import com.github.taojintianxia.cornucopia.databasebenchmark.EnvironmentContext;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

public class PointSelect implements ModelScript {

    private final long tableSize;

    private final Random tableSizeRandom;

    private final Random tableRandom;

    private final long table;

    public PointSelect() {
        tableSize = Long.parseLong(EnvironmentContext.getInstance().getBenchmarkMap().get("tableSize"));
        table = Long.parseLong(EnvironmentContext.getInstance().getBenchmarkMap().get("table"));
        tableSizeRandom = new Random(tableSize);
        tableRandom = new Random(table);
    }

    @Override
    public long getId() {
        return tableSizeRandom.nextLong();
    }

    @SneakyThrows
    public void execute( Connection connection ) {
        PreparedStatement preparedStatement = connection.prepareStatement(getSql());
        preparedStatement.execute();
    }

    private String getSql() {
        return "select c from sbtest%d where id = ?".replace("%d", tableRandom.nextLong() + "");
    }
}
