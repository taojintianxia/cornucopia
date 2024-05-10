package com.github.taojintianxia.cornucopia.shardingsphere.tool.encrypt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class AlterTableGenerator {
    
    public static void main(String ... args) throws IOException {
        String tableName = "tca_contract_info";
        try (InputStream inputStream = AlterTableGenerator.class.getClassLoader().getResourceAsStream("alter_table_column.md"); BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!"".equals(line.trim())) {
                    generateAlterSQL(tableName, extractColumnName(line));
                }
            }
        }
    }
    
    public static String extractColumnName(String line) {
        if (line == null || line.isEmpty()) {
            return "";
        }
        return line.trim();
    }
    
    private static void generateAlterSQL(String tableName, String columnName) {
        System.out.println(String.format("ALTER TABLE %s DROP COLUMN %s_cipher ;", tableName, columnName));
        System.out.println(String.format("ALTER TABLE %s DROP COLUMN %s_like ;", tableName, columnName));
    }
}
