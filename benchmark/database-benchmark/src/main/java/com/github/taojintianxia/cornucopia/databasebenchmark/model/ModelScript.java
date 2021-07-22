package com.github.taojintianxia.cornucopia.databasebenchmark.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public interface ModelScript {

    long getId();

    void execute( PreparedStatement statement ) throws SQLException;
}
