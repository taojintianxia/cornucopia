package com.github.taojintianxia.cornucopia.shardingsphere.tool.encrypt;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 该工具可以根据 Proxy 的洗数配置文件获取所有加密表、列，进而生成对应的数据清理 SQL。
 */
public class DatabaseCleanupGenerator {
    
    private static final String ENCRYPT_LABEL = "!ENCRYPT";
    
    private static final String ENCRYPT_TABLE_LABEL = "  tables:";
    
    public static void main(String... args) {
        transferConfigToCleanupSQL();
    }
    
    @SneakyThrows
    private static void transferConfigToCleanupSQL() {
        Map<String, List<String>> result = new HashMap<>();
        boolean isEncryptLabelShown = false;
        boolean isEncryptTableLabelShown = false;
        boolean isCipherLabelShown = false;
        String currentTable = "";
        try (InputStream inputStream = DatabaseCleanupGenerator.class.getClassLoader().getResourceAsStream("config-encrypt.yaml"); BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!isEncryptLabelShown) {
                    isEncryptLabelShown = scanEncryptLabel(line);
                    continue;
                }
                if (!isEncryptTableLabelShown) {
                    isEncryptTableLabelShown = scanEncryptTableLabel(line);
                    continue;
                }
                if (lineStartSpaceCount(line) == 4 && line.trim().endsWith(":")) {
                    currentTable = extractTableName(line);
                    result.put(currentTable, new ArrayList<>());
                    continue;
                }
                if (lineStartSpaceCount(line) == 10 && line.contains("cipher:")) {
                    isCipherLabelShown = true;
                    continue;
                }
                if (lineStartSpaceCount(line) == 10 && line.contains("plain:")) {
                    isCipherLabelShown = false;
                    continue;
                }
                if (isCipherLabelShown && lineStartSpaceCount(line) == 12 && line.contains("name:")) {
                    result.get(currentTable).add(getEncryptColumnName(line));
                }
            }
        }
        
        result.forEach((key, value) -> {
            value.forEach(column -> System.out.println("UPDATE " + key + " SET " + column + "=NULL WHERE " + column + " IS NOT NULL;COMMIT;"));
        });
    }
    
    private static boolean scanEncryptLabel(String line) {
        return line.contains(ENCRYPT_LABEL);
    }
    
    private static boolean scanEncryptTableLabel(String line) {
        return line.contains(ENCRYPT_TABLE_LABEL);
    }
    
    private static int lineStartSpaceCount(String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
    
    private static String extractTableName(String line) {
        return line.trim().substring(0, line.trim().length() - 1);
    }
    
    private static String getEncryptColumnName(String line) {
        String result = line.trim();
        result = result.substring(result.indexOf(":") + 1).trim();
        if (result.contains("#")){
            result = result.substring(0, result.indexOf("#"));
        }
        if (result.contains(" ")){
            result = result.substring(0, result.indexOf(" "));
        }
        return result.trim();
    }
}
