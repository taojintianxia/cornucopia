package com.github.taojintianxia.cornucopia.databasebenchmark.executor.param;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public final class MySQLBenchmarkParam extends BaseBenchmarkParam{

    private String mysqlHost;

    private int mysqlPort;

    private String mysqlUser;

    private String mysqlPassword;

    private String mysqlDb;
}
