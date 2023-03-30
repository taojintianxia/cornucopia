package com.github.taojintianxia.cornucopia.gists.shardingsphere.sharding.date.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class DateShardingSQLGenerator {
    
    private static final int START_YEAR = 2020;
    
    private static final int END_YEAR = 2025;
    
    private static String TABLE_NAME = "t_order";
    
    private static String CREATE_TABLE_CONTENT = " (order_id INT NOT NULL, user_id INT NOT NULL, status VARCHAR(45) NULL, create_date datetime NOT NULL, PRIMARY KEY (order_id))";
    
    private static final List<String> DATASOURCE_PORT = Arrays.asList("13306", "23306", "33306");
    
    public static void main(String... args) throws Exception {
        initTestData();
    }
    
    private static void printSQL() {
        for (int i = START_YEAR, j = 3; i <= END_YEAR; i++, j++) {
            for (int month = 1; month <= 12; month++) {
                StringBuilder stringBuilder = new StringBuilder("mysql -h127.0.0.1 -uroot -proot -P");
                String port = DATASOURCE_PORT.get(j % DATASOURCE_PORT.size());
                stringBuilder.append(port).append(" -e \"");
                stringBuilder.append("use ds_").append(i).append("; ");
                stringBuilder.append("create table ").append(TABLE_NAME).append("_").append(i);
                if (month < 10) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(month).append(CREATE_TABLE_CONTENT).append("\"");
                System.out.println(stringBuilder);
            }
        }
    }
    
    private static void initTestData() throws ClassNotFoundException, SQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3307/sharding_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
        for (int i = START_YEAR; i <= END_YEAR; i++) {
            Connection connection = DriverManager.getConnection(url, "root", "root");
            for (int x = 0; x < 10; x++) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(i, new Random().nextInt(12), new Random().nextInt(30));
                String insertValue = "insert into t_order values (" + x + ", 1, 'init', '" + formatter.format(calendar.getTime()) + "')";
                connection.prepareStatement(insertValue).execute();
                System.out.println(insertValue);
            }
        }
    }
}
