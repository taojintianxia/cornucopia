package com.github.taojintianxia.cornucopia.gists.shardingsphere.sharding.date.pg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;

public class DateShardingSQLGenerator {
    
    private static String DS_TEMPLATE = "  ds_${YEAR}:\n" +
            "    url: jdbc:postgresql://20.0.36.116:${PORT}/${DS}\n" +
            "    username: hdqpsharding\n" +
            "    password: abc@123456\n";
    
    private static final List<String> portList = Arrays.asList("26000", "27000", "28000");
    
    public static void main(String... args) throws Exception {
        generateDatabaseOnMultiplePG();
    }
    
    private static void generateDatasource() {
        StringBuilder datasourceBuilder = new StringBuilder();
        for (int year = 1999, count = 3; year <= 2027; year++, count++) {
            String port = portList.get(count % portList.size());
            datasourceBuilder.append(DS_TEMPLATE.replace("${YEAR}", year + "").replace("${PORT}", port).replace("${DS}", "ds_" + year));
        }
        System.out.println(datasourceBuilder);
    }
    
    private static void generateDatabasesOnSinglePG() throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:15432/postgres", "postgres", "postgres");
        for (int year = 1999; year <= 2027; year++) {
            // connection.prepareStatement("create database ds_" + year).execute();
            System.out.println("\\c ds_" + year);
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:15432/ds_" + year, "postgres", "postgres");
            for (int month = 1; month <= 12; month++) {
                //                connection.prepareStatement("create table t_order_" + year + (month < 10 ? "0" + month : month) + " (order_id INT NOT NULL, user_id INT NOT NULL, status VARCHAR(45) NULL, create_date VARCHAR(40) NOT NULL, PRIMARY KEY (order_id))").execute();
                System.out.println("create table t_order_" + year + (month < 10 ? "0" + month : month) + " (order_id INT NOT NULL, user_id INT NOT NULL, status VARCHAR(45) NULL, create_date VARCHAR(40) NOT NULL, PRIMARY KEY (order_id))");
            }
            System.out.println();
        }
    }
    
    private static void generateDatabaseOnMultiplePG() {
        List<String> pgList = Arrays.asList("26000", "27000", "28000");
        for (int i = 0; i < pgList.size(); i++) {
            System.out.println(" -- For " + pgList.get(i));
            for (int year = 1999; year <= 2027; year++) {
                if (year % pgList.size() == (i + 1) % pgList.size()) {
                    System.out.println("create database ds_" + year);
                }
            }
        }
    }
}
