package com.github.taojintianxia.cornucopia.databasebenchmark;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class RandomUtilTest {

    private final int LOOP_COUNT = 10000000;

    private final String SQL_TEMPLATE = "select * from sbtest where id = %s";

    private final String SQL_TEMPLATE_MANUAL = "select * from sbtest where id = ";

    @Test
    public void testRandomTime() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < LOOP_COUNT; i++) {
            Random random = new Random();
            random.nextInt(LOOP_COUNT);
        }
        System.out.println(String.format("Random take time : %s", stopwatch.elapsed(TimeUnit.MILLISECONDS)));
    }

    @Test
    public void testRandomTimeWithNoNewInstance() {
        Random random = new Random();
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < LOOP_COUNT; i++) {
            random.nextInt(LOOP_COUNT);
        }
        System.out.println(String.format("Random WithNoNewInstance take time : %s", stopwatch.elapsed(TimeUnit.MILLISECONDS)));
    }

    @Test
    public void testThreadLocalRandom() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < LOOP_COUNT; i++) {
            ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
            threadLocalRandom.nextInt(LOOP_COUNT);
        }
        System.out.println(String.format("ThreadLocalRandom take time : %s", stopwatch.elapsed(TimeUnit.MILLISECONDS)));
    }

    @Test
    public void testThreadLocalRandomWithNoNewInstance() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        for (int i = 0; i < LOOP_COUNT; i++) {
            threadLocalRandom.nextInt(LOOP_COUNT);
        }
        System.out.println(String.format("ThreadLocalRandom WithNoNewInstance take time : %s", stopwatch.elapsed(TimeUnit.MILLISECONDS)));
    }


    @Test
    public void testRandomSqlByFormat() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < LOOP_COUNT; i++) {
            String sql = String.format(SQL_TEMPLATE, ThreadLocalRandom.current().nextInt(LOOP_COUNT));
        }
        System.out.println(String.format("Random Sql take time : %s", stopwatch.elapsed(TimeUnit.MILLISECONDS)));
    }

    @Test
    public void testRandomSqlByReplace() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < LOOP_COUNT; i++) {
            String sql = SQL_TEMPLATE.replace("%s", ThreadLocalRandom.current().nextInt(LOOP_COUNT) + "");
        }
        System.out.println(String.format("Random Sql take time : %s", stopwatch.elapsed(TimeUnit.MILLISECONDS)));
    }

    @Test
    public void testRandomSqlByManually() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < LOOP_COUNT; i++) {
            String sql = SQL_TEMPLATE_MANUAL + ThreadLocalRandom.current().nextInt(LOOP_COUNT);
        }
        System.out.println(String.format("Random Sql take time : %s", stopwatch.elapsed(TimeUnit.MILLISECONDS)));
    }
}
