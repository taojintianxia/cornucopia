package com.github.taojintianxia.cornucopia.jdbctest.statement;

import java.sql.Connection;
import java.sql.SQLException;

public interface SysbenchBenchmark {

    void setConnection(Connection connection) throws SQLException;

    void execute() throws SQLException;
}
