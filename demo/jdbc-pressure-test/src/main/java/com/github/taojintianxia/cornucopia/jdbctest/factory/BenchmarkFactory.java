package com.github.taojintianxia.cornucopia.jdbctest.factory;

import com.github.taojintianxia.cornucopia.jdbctest.statement.PointSelectOrderBy;
import com.github.taojintianxia.cornucopia.jdbctest.statement.ReadWriteBenchmark;
import com.github.taojintianxia.cornucopia.jdbctest.statement.SysbenchBenchmark;

import java.sql.Connection;
import java.sql.SQLException;

public class BenchmarkFactory {

    public static SysbenchBenchmark getBenchmarkByName( String benchmarkName, Connection connection ) throws SQLException {
        if ("oltp_read_write".equals(benchmarkName)) {
            return new ReadWriteBenchmark(connection);
        }
        if ("oltp_order_by".equals(benchmarkName)) {
            return new PointSelectOrderBy(connection);
        }

        throw new UnsupportedOperationException("not support your benchmark");
    }
}
