package com.github.taojintianxia.cornucopia.testcontainers.network;

import com.github.taojintianxia.cornucopia.testcontainers.mysql.container.MySQLContainer;

import java.util.ArrayList;
import java.util.List;

public final class PortMappingExample {
    
    public static void main(String... args) throws Exception {
        MySQLContainer container = new MySQLContainer("mysql:5.7.38").withExposedPorts(3306);
        container.addEnv("MYSQL_ROOT_PASSWORD", "root");
        List<String> portBindings = new ArrayList<>();
        portBindings.add("53306:3306");
        container.setPortBindings(portBindings);
        container.start();
        Thread.sleep(10000000000000L);
    }
}
