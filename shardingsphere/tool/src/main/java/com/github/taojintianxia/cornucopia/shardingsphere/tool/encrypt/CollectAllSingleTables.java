package com.github.taojintianxia.cornucopia.shardingsphere.tool.encrypt;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public final class CollectAllSingleTables {
    
    public static void main(String[] args) throws Exception {
        List<String> tableNames = new ArrayList<>();
        try (InputStream inputStream = AlterTableGenerator.class.getClassLoader().getResourceAsStream("single_table.md"); BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!"".equals(line.trim())) {
                    line = extractTableName(line);
                    if (line.equals("clbxd_link_event")) {
                        continue;
                    }
                    System.out.println("show migration status " + line +";");
                    System.out.println("commit migration " + line +";");
                }
            }
        }
    }
    
    private static String extractTableName(String rawTableName) {
        if (rawTableName == null || rawTableName.isEmpty()) {
            return "";
        }
        rawTableName = rawTableName.trim().substring(0, rawTableName.indexOf("|") -1);
        return rawTableName.trim();
    }
}
