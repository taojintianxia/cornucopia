package com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave.service.impl;

import com.github.taojintianxia.cornucopia.shardingsphere.shardingcommon.entity.Order;
import com.github.taojintianxia.shardingsphere.shardingjdbcexample.rawjdbc.masterslave.service.OrderService;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

/**
 * @author Nianjun Sun
 * @date 2019/10/15 19:20
 */
public class OrderServiceImpl implements OrderService {

    private DataSource dataSource;

    @Override
    @SneakyThrows
    public void saveOrder(Order order) {
        String sql = "insert into t_order values (null," + new SecureRandom().nextInt(1000) + "," + new SecureRandom()
                .nextInt(1000) + ", 'ready')";
        Statement statement = getStatement();
        statement.executeQuery(sql);
    }

    @Override
    public void deleteOder(Long orderId) {

    }

    @Override
    public List<Order> listOrders() {
        return null;
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public void setDataSource(DataSource datasource) {
        this.dataSource = datasource;
    }

    @SneakyThrows
    private Statement getStatement() {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        return statement;
    }
}
