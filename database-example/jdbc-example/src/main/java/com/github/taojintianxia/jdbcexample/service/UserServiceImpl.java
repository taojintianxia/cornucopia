package com.github.taojintianxia.jdbcexample.service;

import com.github.taojintianxia.jdbcexample.entity.User;
import com.github.taojintianxia.jdbcexample.util.ConnectionUtil;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

/**
 * @author Nianjun Sun
 * @date 2019/9/20 10:49
 */
public class UserServiceImpl implements CRUDTemplate<User> {

    private DataSource dataSource;

    @Override
    public long insert(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int deleteById(long id) {
        return 0;
    }

    @Override
    public User selectById(long id) {
        return null;
    }

    @Override
    @SneakyThrows
    public void init() {
        Connection connection = ConnectionUtil.getConnection();
        Statement statement = connection.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS t_order_# (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id))";

        for (int i = 0; i < 2000; i++) {
            String executedSql = sql.replace("#", i + "");
            System.out.println("the executed sql is " + executedSql);
            statement.execute(executedSql);
        }
    }
}
