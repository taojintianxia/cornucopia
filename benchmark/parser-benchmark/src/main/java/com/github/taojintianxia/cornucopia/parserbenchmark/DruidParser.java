package com.github.taojintianxia.cornucopia.parserbenchmark;

import com.alibaba.druid.sql.SQLUtils;
import com.github.taojintianxia.cornucopia.parserbenchmark.constant.SQLConstant;
import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class DruidParser {

    private final static int LOOP_COUNT = 10000000;

    public static void main( String... args ) {
        evaluateSimpleSelect();
    }

    public static void evaluateSimpleSelect() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < LOOP_COUNT; i++) {
            SQLUtils.parseSingleMysqlStatement(SQLConstant.SIMPLE_SELECT);
        }
        log.info("simple select takes : {}", stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }
}

