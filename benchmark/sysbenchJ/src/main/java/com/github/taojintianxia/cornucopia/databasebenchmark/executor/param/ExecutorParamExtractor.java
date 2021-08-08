package com.github.taojintianxia.cornucopia.databasebenchmark.executor.param;

import com.github.taojintianxia.cornucopia.databasebenchmark.constants.BenchmarkConstant;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ExecutorParamExtractor {

    private final static Map<String, String> PARAM_MAP = new HashMap<>();

    private static String SCRIPT;

    private static String COMMAND;

    public static BaseBenchmarkParam extract( String... args ) {
        SCRIPT = args[0];
        if (!BenchmarkConstant.getScriptNameList().contains(SCRIPT)) {
            log.error("script name is incorrect : %, it should be like 'oltp_point_select'");
            throw new RuntimeException("please specify the benchmark script name like 'oltp_point_select' and make it as the very first parameter");
        }

        for (int i = 1; i < args.length; i++) {
            String parameter = args[i];
            if (parameter.startsWith("--")) {
                parameter = parameter.substring(2);
                PARAM_MAP.put(parameter.split("=")[0], parameter.split("=")[1]);
            } else {
                COMMAND = parameter;
            }
        }

        BaseBenchmarkParam baseBenchmarkParam;

        if (PARAM_MAP.get(BenchmarkConstant.DB_DRIVER) == null || BenchmarkConstant.MYSQL_DB.equals(PARAM_MAP.get(BenchmarkConstant.DB_DRIVER))) {
            return MySQLBenchmarkParam.builder().mysqlHost(PARAM_MAP.get(BenchmarkConstant.MYSQL_HOST)).build();
        }

        if (BenchmarkConstant.PGSQL_DB_DRIVER.equals(PARAM_MAP.get(BenchmarkConstant.DB_DRIVER))) {
            return PGSQLBenchmarkParam.builder().pgsqlDb(PARAM_MAP.get(BenchmarkConstant.DB_DRIVER)).build();
        }

        throw new UnsupportedOperationException("does not support the database : " + PARAM_MAP.get(BenchmarkConstant.DB_DRIVER));
    }
}
