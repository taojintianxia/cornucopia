package com.github.taojintianxia.cornucopia.databasebenchmark.executor.param;

import lombok.Data;

import java.sql.PreparedStatement;

@Data
public class ExecutorParam {

    private PreparedStatement preparedStatement;

    private String script;

    private String driver;

    private String host;

    private int port;

    private String user;

    private String password;

    private String db;

    private int thread;

    private int tables;

    private int tableSize;

    private int reportInterval;

    private int time;

    private int percentile;
}
