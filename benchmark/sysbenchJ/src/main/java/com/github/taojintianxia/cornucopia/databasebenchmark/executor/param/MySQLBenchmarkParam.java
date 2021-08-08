package com.github.taojintianxia.cornucopia.databasebenchmark.executor.param;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public final class MySQLBenchmarkParam extends BaseBenchmarkParam{

    final private String mysqlHost;

    final private int mysqlPort;

    final private String mysqlUser;

    final private String mysqlPassword;

    final private String mysqlDb;
}
