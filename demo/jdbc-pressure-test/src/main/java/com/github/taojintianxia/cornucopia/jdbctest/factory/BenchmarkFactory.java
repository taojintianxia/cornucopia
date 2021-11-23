package com.github.taojintianxia.cornucopia.jdbctest.factory;

import com.github.taojintianxia.cornucopia.jdbctest.statement.PointSelect;
import com.github.taojintianxia.cornucopia.jdbctest.statement.PointSelectOrderBy;
import com.github.taojintianxia.cornucopia.jdbctest.statement.ReadWrite;
import com.github.taojintianxia.cornucopia.jdbctest.statement.SysbenchBenchmark;

import java.sql.Connection;
import java.sql.SQLException;

public class BenchmarkFactory {

    public static SysbenchBenchmark getBenchmarkByName( String benchmarkName, Connection connection ) throws SQLException {
        if ("oltp_read_write".equals(benchmarkName)) {
            return new ReadWrite(connection);
        }
        if ("oltp_point_select".equals(benchmarkName)) {
            return new PointSelect(connection);
        }
        if ("oltp_order_by".equals(benchmarkName)) {
            return new PointSelectOrderBy(connection);
        }

        throw new UnsupportedOperationException("not support your benchmark");
    }
}
