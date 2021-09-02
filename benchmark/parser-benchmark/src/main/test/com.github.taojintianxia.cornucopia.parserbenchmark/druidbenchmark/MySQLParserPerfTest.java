/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.taojintianxia.cornucopia.parserbenchmark.druidbenchmark;

import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import junit.framework.TestCase;
import org.apache.shardingsphere.infra.parser.ShardingSphereSQLParserEngine;

public class MySQLParserPerfTest extends TestCase {

    private String sql;

    private final int NOT_CACHE_LOOP_COUNT = 1000 * 1000;

    private final int WITH_CACHE_LOOP_COUNT = 1000 * 10000;

    protected void setUp() {
//        sql = "SELECT * FROM T";
        sql = "SELECT ID, NAME, AGE FROM USER WHERE ID = ?";
    }

    public void test_druid_with_cache() {
        for (int i = 0; i < 10; ++i) {
            parseWithCacheByDruid(sql);
        }
    }

    public void test_druid_without_cache() {
        for (int i = 0; i < 10; ++i) {
            parseWithOutCacheByDruid(sql);
        }
    }

    public void test_ss_with_cache() {
        for (int i = 0; i < 10; ++i) {
            parseWithCacheBySS(sql);
        }
    }

    public void test_ss_without_cache() {
        for (int i = 0; i < 10; ++i) {
            parseWithOutCacheBySS(sql);
        }
    }

    void parseWithCacheByDruid( String sql ) {
        long startYGC = TestUtils.getYoungGC();
        long startYGCTime = TestUtils.getYoungGCTime();
        long startFGC = TestUtils.getFullGC();
        long startMillis = System.currentTimeMillis();
        MySqlStatementParser parser = new MySqlStatementParser(sql);

        for (int i = 0; i < NOT_CACHE_LOOP_COUNT; ++i) {
            parser.parseStatementList();
        }

        long millis = System.currentTimeMillis() - startMillis;
        long ygc = TestUtils.getYoungGC() - startYGC;
        long ygct = TestUtils.getYoungGCTime() - startYGCTime;
        long fgc = TestUtils.getFullGC() - startFGC;

        System.out.println("MySql\t" + millis + ", ygc " + ygc + ", ygct " + ygct + ", fgc " + fgc);
    }

    void parseWithOutCacheByDruid( String sql ) {
        long startYGC = TestUtils.getYoungGC();
        long startYGCTime = TestUtils.getYoungGCTime();
        long startFGC = TestUtils.getFullGC();
        long startMillis = System.currentTimeMillis();

        for (int i = 0; i < NOT_CACHE_LOOP_COUNT; ++i) {
            MySqlStatementParser parser = new MySqlStatementParser(sql);
            parser.parseStatementList();
        }

        long millis = System.currentTimeMillis() - startMillis;
        long ygc = TestUtils.getYoungGC() - startYGC;
        long ygct = TestUtils.getYoungGCTime() - startYGCTime;
        long fgc = TestUtils.getFullGC() - startFGC;

        System.out.println("MySql\t" + millis + ", ygc " + ygc + ", ygct " + ygct + ", fgc " + fgc);
    }

    private void parseWithCacheBySS( String sql ) {
        ShardingSphereSQLParserEngine sqlStatementParserEngine = new ShardingSphereSQLParserEngine("MySQL");
        for (int i = 0; i < NOT_CACHE_LOOP_COUNT; ++i) {
            sqlStatementParserEngine.parse(sql, true);
        }
    }

    private void parseWithOutCacheBySS( String sql ) {
        for (int i = 0; i < NOT_CACHE_LOOP_COUNT; ++i) {
            ShardingSphereSQLParserEngine sqlStatementParserEngine = new ShardingSphereSQLParserEngine("MySQL");
            sqlStatementParserEngine.parse(sql, false);
        }
    }
}
