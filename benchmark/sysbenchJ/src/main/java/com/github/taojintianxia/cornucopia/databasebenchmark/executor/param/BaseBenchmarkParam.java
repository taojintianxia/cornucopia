package com.github.taojintianxia.cornucopia.databasebenchmark.executor.param;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class BaseBenchmarkParam {

    final private int tables;

    final private int tableSize;

    final private int reportInterval;

    final private int time;

    final private int percentile;

    final private int threads;

    final private String command;
}
