package com.github.taojintianxia.cornucopia.databasebenchmark.executor.param;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public final class PGSQLBenchmarkParam extends BaseBenchmarkParam{

    final private String pgsqlHost;

    final private int pgsqlPort;

    final private String pgsqlUser;

    final private String pgsqlPassword;

    final private String pgsqlDb;
}
