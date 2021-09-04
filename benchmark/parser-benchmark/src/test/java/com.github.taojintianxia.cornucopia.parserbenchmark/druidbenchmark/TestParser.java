package com.github.taojintianxia.cornucopia.parserbenchmark.druidbenchmark;

import org.apache.shardingsphere.infra.parser.ShardingSphereSQLParserEngine;

public class TestParser {

    public static void main(final String[] args) {
        ShardingSphereSQLParserEngine engine = new ShardingSphereSQLParserEngine("MySQL");
        long before = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            engine.parse("SELECT ID, NAME, AGE FROM USER WHERE ID = ?", false);
        }
        System.out.println(System.currentTimeMillis() - before);
    }
}
