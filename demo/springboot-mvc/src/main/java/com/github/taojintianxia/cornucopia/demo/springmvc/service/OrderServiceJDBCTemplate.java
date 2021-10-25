package com.github.taojintianxia.cornucopia.demo.springmvc.service;

import com.github.taojintianxia.cornucopia.demo.springmvc.pojo.Order;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class OrderServiceJDBCTemplate {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SneakyThrows
    public List<Order> listAllOrders() throws ClassNotFoundException, SQLException {
        String sql = "SELECT order_id, user_id, status FROM t_order";

        return jdbcTemplate.query(sql, new RowMapper<Order>(){
            @Override
            public Order mapRow( ResultSet rs, int rowNum) throws SQLException {
                Order order = new Order();
                order.setOrderId(rs.getInt("order_id"));
                order.setUserId(rs.getInt("user_id"));
                order.setStatus(rs.getString("status"));
                return order;
            }
        });
    }
}
