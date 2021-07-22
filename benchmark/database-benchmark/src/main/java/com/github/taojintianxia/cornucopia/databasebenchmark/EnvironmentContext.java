package com.github.taojintianxia.cornucopia.databasebenchmark;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class EnvironmentContext {

    private final Properties benchmarkProperties;

    private final Properties databaseProperties;

    private final Map<String, String> benchmarkMap;

    private final Map<String, String> databaseMap;

    private static final EnvironmentContext INSTANCE = new EnvironmentContext();

    @SneakyThrows
    private EnvironmentContext() {
        benchmarkProperties = new Properties();
        databaseProperties = new Properties();
        benchmarkProperties.load(new FileInputStream("benchmark.properties"));
        databaseProperties.load(new FileInputStream("database.properties"));
        benchmarkMap = new HashMap<>(benchmarkProperties.size());
        databaseMap = new HashMap<>(databaseProperties.size());
        benchmarkProperties.forEach(( key, value ) -> benchmarkMap.put(key.toString(), value.toString()));
        databaseProperties.forEach(( key, value ) -> databaseMap.put(key.toString(), value.toString()));
    }

    public static EnvironmentContext getInstance() {
        return INSTANCE;
    }

    public Map<String, String> getBenchmarkMap() {
        return benchmarkMap;
    }

    public Map<String, String> getDatabaseMap() {
        return databaseMap;
    }
}
