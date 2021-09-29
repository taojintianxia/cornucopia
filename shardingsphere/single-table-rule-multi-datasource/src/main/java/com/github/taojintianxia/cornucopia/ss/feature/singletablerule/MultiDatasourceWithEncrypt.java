package com.github.taojintianxia.cornucopia.ss.feature.singletablerule;

import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

public class MultiDatasourceWithEncrypt {

    public static void main( String... args ) throws SQLException, IOException {
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(getFile("/META-INF/encrypt.yaml"));
        testReadWrite(dataSource);
    }

    private static File getFile( final String fileName) {
        return new File(MultiDatasourceWithEncrypt.class.getResource(fileName).getFile());
    }

    private static void testReadWrite(DataSource dataSource) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("CREATE TABLE t_test(test_id INT, user_id VARCHAR(100), order_id VARCHAR(100), content VARCHAR(100));");
        statement.execute();
    }
}
