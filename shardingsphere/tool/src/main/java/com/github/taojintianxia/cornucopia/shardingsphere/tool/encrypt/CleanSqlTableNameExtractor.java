package com.github.taojintianxia.cornucopia.shardingsphere.tool.encrypt;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 该类用于提取清理加密字段 SQL 中的全部表名
 */
public class CleanSqlTableNameExtractor {
    
    @SneakyThrows
    public static void main(String... args) {
        Set<String> tableNames = new HashSet<>();
        try (InputStream inputStream = DatabaseCleanupGenerator.class.getClassLoader().getResourceAsStream("clean_encrypt_column.sql"); BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!"".equals(line.trim())) {
                    tableNames.add(extractTableName(line));
                }
            }
        }
        StringBuilder resultBuilder = new StringBuilder();
        tableNames.forEach(tableName -> resultBuilder.append(tableName).append(", "));
        System.out.println(resultBuilder);
    }
    
    private static String extractTableName(String line) {
        String result = line.substring(line.indexOf("UPDATE ") + 7);
        result = result.substring(0, result.indexOf(" SET"));
        return result.trim();
    }
}
