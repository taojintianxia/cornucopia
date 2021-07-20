package com.github.taojintianxia.jdbcexample.service;

import com.github.taojintianxia.jdbcexample.entity.User;
import com.github.taojintianxia.jdbcexample.util.ConnectionUtil;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

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

    private static final Map<Integer,Statement> STATEMENT_MAP = new HashMap<>();

    private static final int THREAD_POOL_SIZE = 500;

    @Override
    @SneakyThrows
    public void init() {
        Connection connection = ConnectionUtil.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS sharding_db.t_order (order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, status VARCHAR(50), PRIMARY KEY (order_id));\n");
        for(int i = 0; i < 5000000 ;i++) {
            createByThread(i);
        }
    }

    @SneakyThrows
    public void createByThread(int id) {
        Statement statement = STATEMENT_MAP.get(id % THREAD_POOL_SIZE);
        if (statement == null){
            synchronized (this) {
                Connection connection = ConnectionUtil.getConnection();
                statement = connection.createStatement();
                STATEMENT_MAP.put(id % THREAD_POOL_SIZE,statement);
            }
        }
        String sql = "insert into sharding_db.t_order values("+id+",'test')";
        statement.execute(sql);
    }
}
