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

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlOutputVisitor;
import junit.framework.TestCase;
import org.apache.shardingsphere.infra.parser.ShardingSphereSQLParserEngine;

import java.util.List;

public class MySQLPerfTest extends TestCase {

    private String sql;

    private final int NOT_CACHE_LOOP_COUNT = 1000 * 1000;

    private final int WITH_CACHE_LOOP_COUNT = 1000 * 10000;

    protected void setUp() throws Exception {
//        sql = "SELECT * FROM T";
        sql = "SELECT ID, NAME, AGE FROM USER WHERE ID = ?";
    }

    public void test_druid_with_cache() throws Exception {
        for (int i = 0; i < 10; ++i) {
            parseWithCacheByDruid(sql, "druid");
        }
    }

    public void test_druid_without_cache() throws Exception {
        for (int i = 0; i < 10; ++i) {
            parseWithCacheByDruid(sql, "druid");
        }
    }

    public void test_ss() throws Exception {
        for (int i = 0; i < 10; ++i) {
            parseWithCacheByDruid(sql, "ss");
        }
    }

    void parseWithCacheByDruid( String sql, String engine ) {
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

    private String execMySqlByDruildParser( String sql ) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < NOT_CACHE_LOOP_COUNT; ++i) {
            MySqlOutputVisitor visitor = new MySqlOutputVisitor(out);
            MySqlStatementParser parser = new MySqlStatementParser(sql);
            List<SQLStatement> statementList = parser.parseStatementList();
            for (SQLStatement statement : statementList) {
                statement.accept(visitor);
                visitor.println();
            }
        }

        return out.toString();
    }

    private String execMySqlBySSParser( String sql ) {
        StringBuilder out = new StringBuilder();
        ShardingSphereSQLParserEngine sqlStatementParserEngine = new ShardingSphereSQLParserEngine("MySQL");
        for (int i = 0; i < NOT_CACHE_LOOP_COUNT; ++i) {
            org.apache.shardingsphere.sql.parser.sql.common.statement.SQLStatement statement = sqlStatementParserEngine.parse(sql, false);
        }
        // for (SQLStatement statement : statementList) {
        // statement.accept(visitor);
        // visitor.println();
        // }
        return out.toString();
    }
}
