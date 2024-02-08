package com.github.taojintianxia.cornucopia.shardingsphere.tool.encrypt;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 该类用于提取清理加密字段 SQL 中的全部表名
 */
public class CleanSqlTableNameExtractor {
    
    @SneakyThrows
    public static void main(String... args) {
        List<String> tableNames = new ArrayList<>();
        try (InputStream inputStream = DatabaseCleanupGenerator.class.getClassLoader().getResourceAsStream("clean_encrypt_column.sql"); BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tableNames.add(extractTableName(line));
            }
        }
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < tableNames.size(); i++) {
            resultBuilder.append(tableNames.get(i));
            if (i != tableNames.size() - 1) {
                resultBuilder.append(", ");
            }
        }
        System.out.println(resultBuilder);
    }
    
    private static String extractTableName(String line) {
        String result = line.substring(line.indexOf("UPDATE ") + 7);
        result = result.substring(0, result.indexOf(" SET"));
        return result.trim();
    }
}
