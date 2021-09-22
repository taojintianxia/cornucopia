package com.github.taojintianxia.cornucopia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLLoadBalancerTest {

    private static final String URL = "jdbc:mysql:loadbalance://127.0.0.1:23306,127.0.0.1:23307/sbtest?" +
                                      "loadBalanceConnectionGroup=first&loadBalanceEnableJMX=true";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "root";

    public static void main( String... args ) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        for (int i =0 ;i < 20 ;i++) {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from sbtest1 where id = ?");
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("---------------------");
                System.out.println("column 1 : " + resultSet.getString(2));
            }
        }
    }
}
