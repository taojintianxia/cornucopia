package com.github.taojintianxia.cornucopia.databasebenchmark.executor.param;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public final class PGSQLBenchmarkParam extends BaseBenchmarkParam{

    final private String pgsqlHost;

    final private int pgsqlPort;

    final private String pgsqlUser;

    final private String pgsqlPassword;

    final private String pgsqlDb;
}
