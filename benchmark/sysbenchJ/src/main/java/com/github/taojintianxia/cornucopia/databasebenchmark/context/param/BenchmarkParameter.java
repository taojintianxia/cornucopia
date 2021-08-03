package com.github.taojintianxia.cornucopia.databasebenchmark.context.param;

import lombok.Data;

@Data
public class BenchmarkParameter {

    private String driver;

    private int thread;

    private int table;

    private int tableSize;
}
