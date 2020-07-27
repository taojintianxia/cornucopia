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
        String sql = "UPDATE t_frozen_subaccount\n" + "      SET f_version = f_version + 1\n"
                + "      WHERE f_id = 1000 and f_user_id = 1000 ;\n" + "\n"
                + "      UPDATE t_subaccount SET f_version = f_version + 1\n"
                + "      WHERE f_id = 2000 AND f_version = 2000 and f_user_id = 2000;";


            statement.execute(sql);

    }
}
