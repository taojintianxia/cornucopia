package com.github.taojintianxia.cornucopia.databasebenchmark;

import com.github.taojintianxia.cornucopia.databasebenchmark.model.PointSelect;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Terminal implements Runnable{

    @Setter
    private DataSource dataSource;

    @SneakyThrows
    @Override
    public void run() {
        PointSelect pointSelect = new PointSelect();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(pointSelect.getSql());
        while (true) {
            pointSelect.execute(preparedStatement);
        }
    }
}
