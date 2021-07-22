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
        tableSize = Long.parseLong(EnvironmentContext.getInstance().getProperty("tableSize"));
        table = Long.parseLong(EnvironmentContext.getInstance().getProperty("table"));
        tableSizeRandom = new Random(tableSize);
        tableRandom = new Random(table);
    }

    @Override
    public long getId() {
        return tableSizeRandom.nextLong();
    }

    @SneakyThrows
    public void execute(Connection connection) {
        String sql = "select c from sbtest%table where id = %tableSize".replace("%tableSize", tableSizeRandom.nextLong() + "")
                .replace("%table", tableRandom.nextLong() + "");
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
    }
}
