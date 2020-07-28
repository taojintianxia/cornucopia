package com.github.taojintianxia.cornucopia.h2.h2java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author Nianjun Sun
 * @date 2020/7/28 08:12
 */
public class MainExample {

    public static void main(final String... args) throws Exception {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:~/test;MODE=MySQL;INIT=RUNSCRIPT FROM 'classpath:scripts/create_script.sql'", "sa", "");
        Statement statement = connection.createStatement();
        connection.close();
    }
}
