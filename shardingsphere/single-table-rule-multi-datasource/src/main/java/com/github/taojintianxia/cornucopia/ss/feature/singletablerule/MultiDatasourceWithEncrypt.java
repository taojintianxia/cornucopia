package com.github.taojintianxia.cornucopia.ss.feature.singletablerule;

import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class MultiDatasourceWithEncrypt {

    public static void main( String... args ) throws SQLException, IOException {
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(getFile("/META-INF/encrypt.yaml"));
        testReadWriteEncrypt(dataSource);
    }

    private static File getFile( final String fileName) {
        return new File(MultiDatasourceWithEncrypt.class.getResource(fileName).getFile());
    }

    private static void testReadWriteEncrypt(DataSource dataSource) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement("DROP TABLE t_encrypt;").execute();
        connection.prepareStatement("CREATE TABLE t_encrypt(encrypt_id INT, user_id VARCHAR(100), order_id VARCHAR(100), content VARCHAR(100));").execute();
        connection.prepareStatement("INSERT INTO t_encrypt(encrypt_id, user_id, order_id, content) VALUES(1, '11', '11', '11'), (2, '22', '22', '22');").execute();
        connection.prepareStatement("SELECT * FROM t_encrypt;").execute();
        connection.prepareStatement("DELETE FROM t_encrypt WHERE encrypt_id = 1;").execute();
        connection.prepareStatement("TRUNCATE TABLE t_encrypt;").execute();
        connection.prepareStatement("DROP TABLE t_encrypt;").execute();
    }

    // can not refactor this, because I will test the sql separately and have to stop for some time.
    private static void testReadWriteSingle(DataSource dataSource) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.prepareStatement("DROP TABLE t_single;").execute();
        connection.prepareStatement("CREATE TABLE t_single(single_id INT, content VARCHAR(100));").execute();
        connection.prepareStatement("ALTER TABLE t_single ADD COLUMN product_id INT;").execute();
        connection.prepareStatement("INSERT INTO t_single(single_id, content) VALUES(1, '11'), (2, '22');").execute();
        connection.prepareStatement("UPDATE t_single SET content = '222' WHERE single_id = 2;").execute();
        connection.prepareStatement("SELECT * FROM t_single;").execute();
        connection.prepareStatement("DELETE FROM t_single WHERE single_id = 1;").execute();
        connection.prepareStatement("TRUNCATE TABLE t_single;").execute();
        connection.prepareStatement("DROP TABLE t_single;").execute();
    }
}
