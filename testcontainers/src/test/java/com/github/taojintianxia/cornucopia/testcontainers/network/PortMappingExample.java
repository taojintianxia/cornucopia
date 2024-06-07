package com.github.taojintianxia.cornucopia.testcontainers.network;

import com.github.taojintianxia.cornucopia.testcontainers.mysql.container.MySQLContainer;
import org.testcontainers.shaded.org.awaitility.Awaitility;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public final class PortMappingExample {
    
    public static void main(String... args) throws Exception {
        try (MySQLContainer container = new MySQLContainer("mysql:5.7.38").withExposedPorts(3306)) {
            container.addEnv("MYSQL_ROOT_PASSWORD", "root");
            List<String> portBindings = new LinkedList<>();
            portBindings.add("53306:3306");
            container.setPortBindings(portBindings);
            container.start();
            Awaitility.await().pollDelay(Duration.ofMinutes(10)).timeout(Duration.ofMinutes(15)).until(() -> true);
        }
    }
}
