package com.github.taojintianxia.cornucopia.parserbenchmark;

import com.github.taojintianxia.cornucopia.parserbenchmark.constant.SQLConstant;
import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sql.parser.core.parser.SQLParserExecutor;

import java.util.concurrent.TimeUnit;

@Slf4j
public class ShardingParser5 {

    private final static int LOOP_COUNT = 10000000;

    public static void main(String...args) {
        evaluateSimpleSelect();
    }

    public static void evaluateSimpleSelect() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        SQLParserExecutor sqlParserExecutor = new SQLParserExecutor("MySQL");
        for (int i = 0; i < LOOP_COUNT; i++) {
            sqlParserExecutor.parse(SQLConstant.SIMPLE_SELECT);
        }
        log.info("simple select takes : {}", stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}
