package com.github.taojintianxia.jdbcexample.util;

import lombok.SneakyThrows;

import java.util.Properties;

/**
 * @author Nianjun Sun
 * @date 2019/10/14 18:11
 */
public class PropertiesReader {

    @SneakyThrows
    public static Properties readProperties() {
        Properties properties = new Properties();
        properties.load(PropertiesReader.class.getClassLoader().getResourceAsStream("datasource.properties"));
        return properties;
    }
}
