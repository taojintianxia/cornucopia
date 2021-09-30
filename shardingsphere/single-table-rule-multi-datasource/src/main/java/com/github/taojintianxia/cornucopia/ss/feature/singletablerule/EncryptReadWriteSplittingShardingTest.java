package com.github.taojintianxia.cornucopia.ss.feature.singletablerule;

import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class EncryptReadWriteSplittingShardingTest {

    public static void main( String... args ) throws SQLException, IOException {
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(getFile("/META-INF/encrypt.yaml"));
        testOrder(dataSource);
        testUser(dataSource);
        testSingle(dataSource);
        testConfig(dataSource);
        testJoin(dataSource);
    }

    private static File getFile( final String fileName ) {
        return new File(EncryptTest.class.getResource(fileName).getFile());
    }

    private static void testOrder( DataSource dataSource ) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement("DROP TABLE IF EXISTS t_order;").execute();
        connection.prepareStatement("CREATE TABLE t_order(order_id INT, content VARCHAR(100), user_id VARCHAR(100));").execute();
        connection.prepareStatement("ALTER TABLE t_order ADD COLUMN product_id INT;").execute();

        connection.prepareStatement("INSERT INTO t_order(order_id, user_id, content) VALUES(1, 1, '11'), (2, 2, '22');").execute();
        connection.prepareStatement("UPDATE t_order SET content = '222' WHERE order_id = 2;").execute();
        connection.prepareStatement("SELECT * FROM t_order;").execute();
        connection.prepareStatement("SELECT order_id, content FROM t_order;").execute();
        connection.prepareStatement("DELETE FROM t_order WHERE order_id = 1;").execute();

        connection.prepareStatement("TRUNCATE TABLE t_order;").execute();
        connection.prepareStatement("DROP TABLE t_order;").execute();
    }

    private static void testUser( DataSource dataSource ) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement("DROP TABLE IF EXISTS t_user;").execute();
        connection.prepareStatement("CREATE TABLE t_user(id INT, content VARCHAR(100));").execute();
        connection.prepareStatement("ALTER TABLE t_user ADD COLUMN product_id INT;").execute();

        connection.prepareStatement("INSERT INTO t_user(id, content) VALUES(1, '11'), (2, '22');").execute();
        connection.prepareStatement("UPDATE t_user SET content = '222' WHERE id = 2;").execute();
        connection.prepareStatement("SELECT * FROM t_user;").execute();
        connection.prepareStatement("SELECT id, content FROM t_user;").execute();
        connection.prepareStatement("DELETE FROM t_user WHERE id = 1;").execute();

        connection.prepareStatement("TRUNCATE TABLE t_user;").execute();
        connection.prepareStatement("DROP TABLE t_user;").execute();
    }

    private static void testSingle( DataSource dataSource ) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement("DROP TABLE IF EXISTS t_single_test_01;").execute();
        connection.prepareStatement("CREATE TABLE t_single_test_01(id INT, content VARCHAR(100));").execute();
        connection.prepareStatement("ALTER TABLE t_single_test_01 ADD COLUMN product_id INT;").execute();

        connection.prepareStatement("INSERT INTO t_single_test_01(id, content) VALUES(1, '11'), (2, '22');").execute();
        connection.prepareStatement("UPDATE t_single_test_01 SET content = '222' WHERE id = 2;").execute();
        connection.prepareStatement("SELECT * FROM t_single_test_01;").execute();
        connection.prepareStatement("SELECT id, content FROM t_single_test_01;").execute();
        connection.prepareStatement("DELETE FROM t_single_test_01 WHERE id = 1;").execute();

        connection.prepareStatement("TRUNCATE TABLE t_single_test_01;").execute();
        connection.prepareStatement("DROP TABLE t_single_test_01;").execute();
    }

    private static void testConfig( DataSource dataSource ) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement("DROP TABLE IF EXISTS t_config;").execute();
        connection.prepareStatement("CREATE TABLE t_config(id INT, content VARCHAR(100));").execute();
        connection.prepareStatement("ALTER TABLE t_config ADD COLUMN product_id INT;").execute();

        connection.prepareStatement("INSERT INTO t_config(id, content) VALUES(1, '11'), (2, '22');").execute();
        connection.prepareStatement("UPDATE t_config SET content = '222' WHERE id = 2;").execute();
        connection.prepareStatement("SELECT * FROM t_config;").execute();
        connection.prepareStatement("SELECT id, content FROM t_config;").execute();
        connection.prepareStatement("DELETE FROM t_config WHERE id = 1;").execute();

        connection.prepareStatement("TRUNCATE TABLE t_config;").execute();
        connection.prepareStatement("DROP TABLE t_config;").execute();
    }

    private static void testJoin( DataSource dataSource ) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement("DROP TABLE IF EXISTS t_user;").execute();
        connection.prepareStatement("DROP TABLE IF EXISTS t_order;").execute();
        connection.prepareStatement("DROP TABLE IF EXISTS t_single_test_01;").execute();
        connection.prepareStatement("DROP TABLE IF EXISTS t_config;").execute();

        connection.prepareStatement("CREATE TABLE t_order(order_id INT, content VARCHAR(100), user_id VARCHAR(100));").execute();
        connection.prepareStatement("ALTER TABLE t_order ADD COLUMN product_id INT;").execute();
        connection.prepareStatement("INSERT INTO t_order(order_id, user_id, content) VALUES(1, 1, '11'), (2, 2, '22');").execute();
        connection.prepareStatement("CREATE TABLE t_user(id INT, content VARCHAR(100));").execute();
        connection.prepareStatement("ALTER TABLE t_user ADD COLUMN product_id INT;").execute();
        connection.prepareStatement("INSERT INTO t_user(id, content) VALUES(1, '11'), (2, '22');").execute();
        connection.prepareStatement("INSERT INTO t_user(id, content) VALUES(1, '11'), (2, '22');").execute();
        connection.prepareStatement("CREATE TABLE t_single_test_01(id INT, content VARCHAR(100));").execute();
        connection.prepareStatement("ALTER TABLE t_single_test_01 ADD COLUMN product_id INT;").execute();
        connection.prepareStatement("INSERT INTO t_single_test_01(id, content) VALUES(1, '11'), (2, '22');").execute();
        connection.prepareStatement("INSERT INTO t_single_test_01(id, content) VALUES(1, '11'), (2, '22');").execute();
        connection.prepareStatement("CREATE TABLE t_config(id INT, content VARCHAR(100));").execute();
        connection.prepareStatement("ALTER TABLE t_config ADD COLUMN product_id INT;").execute();
        connection.prepareStatement("INSERT INTO t_config(id, content) VALUES(1, '11'), (2, '22');").execute();
        connection.prepareStatement("INSERT INTO t_config(id, content) VALUES(1, '11'), (2, '22');").execute();

        ResultSet resultSet = connection.prepareStatement("SELECT * FROM t_order o INNER JOIN t_user u ON o.order_id = u.id WHERE o.order_id = 1;").executeQuery();
        while (resultSet.next()) {
            System.out.println("the content is " + resultSet.getString("content"));
        }

        resultSet = connection.prepareStatement("SELECT * FROM t_order o INNER JOIN t_single_test_01 s ON o.order_id = s.id WHERE o.order_id = 1;").executeQuery();
        while (resultSet.next()) {
            System.out.println("the content is " + resultSet.getString("content"));
        }

        resultSet = connection.prepareStatement("SELECT * FROM t_order o INNER JOIN t_config c ON o.order_id = c.id WHERE o.order_id = 1;").executeQuery();
        while (resultSet.next()) {
            System.out.println("the content is " + resultSet.getString("content"));
        }

        resultSet = connection.prepareStatement("SELECT * FROM t_user u INNER JOIN t_single_test_01 s ON u.id = s.id WHERE u.id = 1;").executeQuery();
        while (resultSet.next()) {
            System.out.println("the content is " + resultSet.getString("content"));
        }

        resultSet = connection.prepareStatement("SELECT * FROM t_user u INNER JOIN t_config c ON u.id = c.id WHERE u.id = 1;").executeQuery();
        while (resultSet.next()) {
            System.out.println("the content is " + resultSet.getString("content"));
        }
    }
}
