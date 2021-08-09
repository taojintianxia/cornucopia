package com.github.taojintianxia.cornucopia.databasebenchmark.executor;

import com.github.taojintianxia.cornucopia.databasebenchmark.constants.BenchmarkConstant;
import com.github.taojintianxia.cornucopia.databasebenchmark.executor.param.BaseBenchmarkParam;
import com.github.taojintianxia.cornucopia.databasebenchmark.executor.param.MySQLBenchmarkParam;
import com.github.taojintianxia.cornucopia.databasebenchmark.executor.param.PGSQLBenchmarkParam;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ExecutorParamExtractor {

    private final static Map<String, String> PARAM_MAP = new HashMap<>();

    private final static String PARAM_SPLITTER = "=";

    public static BaseBenchmarkParam extract( String... args ) {
        String SCRIPT = args[0];
        String COMMAND = "";
        if (!BenchmarkConstant.getScriptNameList().contains(SCRIPT)) {
            log.error("script name is incorrect : %, it should be like 'oltp_point_select'");
            throw new RuntimeException("please specify the benchmark script name like 'oltp_point_select' and make it as the very first parameter");
        }

        for (int i = 1; i < args.length; i++) {
            String parameter = args[i];
            if (parameter.startsWith("--")) {
                parameter = parameter.substring(2);
                PARAM_MAP.put(parameter.split(PARAM_SPLITTER)[0], parameter.split(PARAM_SPLITTER)[1]);
            } else {
                COMMAND = parameter;
            }
        }

        if (PARAM_MAP.get(BenchmarkConstant.DB_DRIVER) == null || BenchmarkConstant.MYSQL_DB.equals(PARAM_MAP.get(BenchmarkConstant.DB_DRIVER))) {
            return MySQLBenchmarkParam.builder()
                    .driver(BenchmarkConstant.MYSQL_DB_DRIVER)
                    .tables(Integer.parseInt(PARAM_MAP.get(BenchmarkConstant.TABLES)))
                    .tableSize(Integer.parseInt(PARAM_MAP.get(BenchmarkConstant.TABLE_SIZE)))
                    .threads(Integer.parseInt(PARAM_MAP.get(BenchmarkConstant.THREADS)))
                    .reportInterval(Integer.parseInt(PARAM_MAP.get(BenchmarkConstant.REPORT_INTERVAL)))
                    .time(Integer.parseInt(PARAM_MAP.get(BenchmarkConstant.TIME)))
                    .percentile(Integer.parseInt(PARAM_MAP.get(BenchmarkConstant.PERCENTILE)))
                    .command(COMMAND)
                    .mysqlDb(PARAM_MAP.get(BenchmarkConstant.MYSQL_DB))
                    .mysqlPort(Integer.parseInt(PARAM_MAP.get(BenchmarkConstant.MYSQL_PORT)))
                    .mysqlHost(PARAM_MAP.get(BenchmarkConstant.MYSQL_HOST))
                    .mysqlUser(PARAM_MAP.get(BenchmarkConstant.MYSQL_USER))
                    .mysqlPassword(PARAM_MAP.get(BenchmarkConstant.MYSQL_PASSWORD))
                    .build();
        }
        if (BenchmarkConstant.PGSQL_DB_DRIVER.equals(PARAM_MAP.get(BenchmarkConstant.DB_DRIVER))) {
            return PGSQLBenchmarkParam.builder().pgsqlDb(PARAM_MAP.get(BenchmarkConstant.DB_DRIVER)).build();
        }

        throw new UnsupportedOperationException("does not support the database : " + PARAM_MAP.get(BenchmarkConstant.DB_DRIVER));
    }
}
