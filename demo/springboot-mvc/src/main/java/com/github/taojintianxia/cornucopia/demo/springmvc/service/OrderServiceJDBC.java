package com.github.taojintianxia.cornucopia.demo.springmvc.service;

import com.github.taojintianxia.cornucopia.demo.springmvc.pojo.Order;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceJDBC {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;


    @SneakyThrows
    public List<Order> listAllOrders() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sql = "SELECT order_id, user_id, status FROM t_order";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Order> orderList = new ArrayList<>();
        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(resultSet.getInt("order_id"));
            order.setUserId(resultSet.getInt("user_id"));
            order.setStatus(resultSet.getString("status"));
            orderList.add(order);
        }

        return orderList;


//        return jdbcTemplate.query(sql, new RowMapper<Order>(){
//            @Override
//            public Order mapRow( ResultSet rs, int rowNum) throws SQLException {
//                Order order = new Order();
//                order.setOrderId(rs.getInt("order_id"));
//                order.setUserId(rs.getInt("user_id"));
//                order.setStatus(rs.getString("status"));
//                return order;
//            }
//        });
    }
}
