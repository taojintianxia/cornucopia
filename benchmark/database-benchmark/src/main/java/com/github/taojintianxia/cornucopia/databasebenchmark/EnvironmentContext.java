package com.github.taojintianxia.cornucopia.databasebenchmark;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;


public class EnvironmentContext {

    private final Properties properties;

    private final Map<String, String> environmentMap;

    private static final EnvironmentContext INSTANCE = new EnvironmentContext();

    @SneakyThrows
    private EnvironmentContext() {
        properties = new Properties();
        properties.load(new FileInputStream("database.properties"));
        environmentMap = new HashMap<>();
        properties.forEach(( key, value ) -> environmentMap.put(key.toString(), value.toString()));
    }

    public static EnvironmentContext getInstance() {
        return INSTANCE;
    }

    public String getProperty(String key) {
        return environmentMap.get(key);
    }
}
