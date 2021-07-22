package com.github.taojintianxia.cornucopia.databasebenchmark;

import com.github.taojintianxia.cornucopia.databasebenchmark.context.EnvironmentContext;
import com.github.taojintianxia.cornucopia.databasebenchmark.model.PointSelect;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class PointSelectTerminal implements Runnable {

    @Setter
    private DataSource dataSource;

    @SneakyThrows
    @Override
    public void run() {
        PointSelect pointSelect = new PointSelect();
        Connection connection = dataSource.getConnection();
        int tableCount = Integer.parseInt(EnvironmentContext.getInstance().getBenchmarkMap().get("table"));
        List<PreparedStatement> preparedStatementList = new ArrayList<>(tableCount);
        for (int i = 1; i <= tableCount; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(pointSelect.getSql().replace("%d", i + ""));
            preparedStatementList.add(preparedStatement);
        }
        while (true) {
            pointSelect.execute(preparedStatementList);
        }
    }
}
