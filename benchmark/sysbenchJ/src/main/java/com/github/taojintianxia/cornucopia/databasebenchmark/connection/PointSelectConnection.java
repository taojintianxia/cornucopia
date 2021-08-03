package com.github.taojintianxia.cornucopia.databasebenchmark.connection;

import java.sql.Connection;
import java.util.List;

public class PointSelectConnection implements BenchmarkConnection<List<Connection>> {

    @Override
    public List<Connection> getBenchmarkConnection() {
        return null;
    }
}
