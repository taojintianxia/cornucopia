package com.github.taojintianxia.cornucopia.databasebenchmark.model;

import com.github.taojintianxia.cornucopia.databasebenchmark.connection.BenchmarkConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public interface ModelScript <T> {

    long getId();

    void execute( T statement ) throws SQLException;
}
