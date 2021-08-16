package com.github.taojintianxia.cornucopia.parserbenchmark.executor;

import com.alibaba.druid.sql.SQLUtils;
import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.infra.parser.ShardingSphereSQLParserEngine;

import java.util.concurrent.TimeUnit;

@Slf4j
public class SqlExecutor {

    private final static int LOOP_COUNT = 10000000;

    public static void executeAndEvaluateSqlByShardingParser5( String sql ) {
        executeAndEvaluateSqlByShardingParser5("sql", sql);
    }

    public static void executeAndEvaluateSqlByShardingParser5( String caseName, String sql ) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        ShardingSphereSQLParserEngine sqlStatementParserEngine = new ShardingSphereSQLParserEngine("MySQL");
        for (int i = 0; i < LOOP_COUNT; i++) {
            sqlStatementParserEngine.parse(sql, true);
        }
        log.info("{} execution takes : {}", caseName, stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    public static void executeAndEvaluateSqlByDruid( String sql ) {
        executeAndEvaluateSqlByDruid("sql", sql);
    }

    public static void executeAndEvaluateSqlByDruid( String caseName, String sql ) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < LOOP_COUNT; i++) {
            SQLUtils.parseSingleMysqlStatement(sql);
        }
        log.info("{} execution takes : {}",caseName, stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
