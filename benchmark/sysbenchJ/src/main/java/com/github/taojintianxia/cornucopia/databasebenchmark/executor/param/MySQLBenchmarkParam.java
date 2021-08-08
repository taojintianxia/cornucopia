package com.github.taojintianxia.cornucopia.databasebenchmark.executor.param;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public final class MySQLBenchmarkParam extends BaseBenchmarkParam{

    final private String mysqlHost;

    final private int mysqlPort;

    final private String mysqlUser;

    final private String mysqlPassword;

    final private String mysqlDb;
}
