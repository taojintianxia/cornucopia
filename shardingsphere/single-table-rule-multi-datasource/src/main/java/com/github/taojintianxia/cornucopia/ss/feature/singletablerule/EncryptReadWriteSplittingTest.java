package com.github.taojintianxia.cornucopia.ss.feature.singletablerule;

import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class EncryptReadWriteSplittingTest {

    public static void main( String... args ) throws SQLException, IOException {
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(getFile("/META-INF/encrypt.yaml"));
//        testEncrypt(dataSource);
//        testSingle(dataSource);
        testJoin(dataSource);
    }

    private static File getFile( final String fileName ) {
        return new File(EncryptTest.class.getResource(fileName).getFile());
    }

    private static void testEncrypt( DataSource dataSource ) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement("DROP TABLE IF EXISTS t_test;").execute();
        connection.prepareStatement("CREATE TABLE t_test(test_id INT, user_id VARCHAR(100), order_id VARCHAR(100), content VARCHAR(100));").execute();
        connection.prepareStatement("ALTER TABLE t_test ADD COLUMN product_id INT;").execute();
        connection.prepareStatement("INSERT INTO t_test(test_id, user_id, order_id, content) VALUES(1, '11', '11', '11'), (2, '22', '22', '22');").execute();
        connection.prepareStatement("UPDATE t_test SET content = '222' WHERE test_id = 2;").execute();
        connection.prepareStatement("SELECT * FROM t_test;").execute();
        connection.prepareStatement("DELETE FROM t_test WHERE test_id = 1;").execute();
        connection.prepareStatement("DROP TABLE t_test;").execute();
    }

    private static void testSingle( DataSource dataSource ) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement("DROP TABLE IF EXISTS t_single;").execute();
        connection.prepareStatement("CREATE TABLE t_single(single_id INT, content VARCHAR(100));").execute();
        connection.prepareStatement("ALTER TABLE t_single ADD COLUMN product_id INT;").execute();
        connection.prepareStatement("INSERT INTO t_single(single_id, content) VALUES(1, '11'), (2, '22');").execute();
        connection.prepareStatement("UPDATE t_single SET content = '222' WHERE single_id = 2;").execute();
        connection.prepareStatement("SELECT * FROM t_single;").execute();
        connection.prepareStatement("DELETE FROM t_single WHERE single_id = 1;").execute();
        connection.prepareStatement("TRUNCATE TABLE t_single;").execute();
        connection.prepareStatement("DROP TABLE t_single;").execute();
    }

    private static void testJoin( DataSource dataSource ) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement("DROP TABLE IF EXISTS t_test;").execute();
        connection.prepareStatement("DROP TABLE IF EXISTS t_single;").execute();
        connection.prepareStatement("CREATE TABLE t_test(test_id INT, user_id VARCHAR(100), order_id VARCHAR(100), content VARCHAR(100));").execute();
        connection.prepareStatement("ALTER TABLE t_test ADD COLUMN product_id INT;").execute();
        connection.prepareStatement("INSERT INTO t_test(test_id, user_id, order_id, content) VALUES(1, '11', '11', '11'), (2, '22', '22', '22');").execute();
        connection.prepareStatement("CREATE TABLE t_single(single_id INT, content VARCHAR(100));").execute();
        connection.prepareStatement("ALTER TABLE t_single ADD COLUMN product_id INT;").execute();
        connection.prepareStatement("INSERT INTO t_single(single_id, content) VALUES(1, '11'), (2, '22');").execute();
        ResultSet resultSet = connection.prepareStatement("SELECT * FROM t_test t INNER JOIN t_single s ON t.test_id = s.single_id WHERE t.test_id = 1;").executeQuery();
        while (resultSet.next()) {
            System.out.println("the content is " + resultSet.getString("content"));
        }
    }
}
