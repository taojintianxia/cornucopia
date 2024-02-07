package com.github.taojintianxia.cornucopia.shardingsphere.tool.encrypt;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 该工具可以根据 Proxy 的洗数配置文件获取所有加密表、列，进而生成对应的数据清理 SQL。
 */
public class DatabaseCleanupGenerator {
    
    public static void main(String... args) {
        transferConfigToCleanupSQL();
    }
    
    @SneakyThrows
    private static void transferConfigToCleanupSQL() {
        try (InputStream inputStream = DatabaseCleanupGenerator.class.getClassLoader().getResourceAsStream("config-encrypt.yaml"); BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
