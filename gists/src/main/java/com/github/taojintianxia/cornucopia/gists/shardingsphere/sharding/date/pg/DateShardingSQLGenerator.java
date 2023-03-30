package com.github.taojintianxia.cornucopia.gists.shardingsphere.sharding.date.pg;

import java.sql.Connection;
import java.sql.DriverManager;

public class DateShardingSQLGenerator {
    
    private static String DS_TEMPLATE = "  ds_${YEAR}:\n" +
            "    url: jdbc:mysql://127.0.0.1:13306/ds_2020?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true\n" +
            "    username: root\n" +
            "    password: root\n" +
            "    connectionTimeoutMilliseconds: 30000\n" +
            "    idleTimeoutMilliseconds: 60000\n" +
            "    maxLifetimeMilliseconds: 1800000\n" +
            "    maxPoolSize: 5\n" +
            "    minPoolSize: 1";
    
    public static void main(String... args) throws Exception {
        generateDatabases();
    }
    
    private static void generateDatabases() throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:15432/postgres", "postgres", "postgres");
        for (int year = 1999; year <= 2027; year++) {
            // connection.prepareStatement("create database ds_" + year).execute();
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:15432/ds_" + year, "postgres", "postgres");
            for (int month = 1; month <= 12; month++) {
                connection.prepareStatement("create table t_order_" + year + (month < 10 ? "0" + month : month) + " (order_id INT NOT NULL, user_id INT NOT NULL, status VARCHAR(45) NULL, create_date VARCHAR(40) NOT NULL, PRIMARY KEY (order_id))").execute();
            }
        }
    }
}
