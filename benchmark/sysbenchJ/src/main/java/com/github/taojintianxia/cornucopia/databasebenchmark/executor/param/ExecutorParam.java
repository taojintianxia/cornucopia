package com.github.taojintianxia.cornucopia.databasebenchmark.executor.param;

import lombok.Data;

@Data
public class ExecutorParam {

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
