package com.github.taojintianxia.cornucopia.testcontainers.mysql.container;

import org.testcontainers.containers.FixedHostPortGenericContainer;

/**
 * @author Nianjun Sun
 * @date 2019/9/10 12:56
 */
public class MySQLContainer extends FixedHostPortGenericContainer<MySQLContainer> {

    public static final int MySQL_PORT = 13306;

    public static final String DEFAULT_IMAGE_AND_TAG = "mysql:5.7";

    public MySQLContainer() {
        this(DEFAULT_IMAGE_AND_TAG);
    }

    public MySQLContainer(String image) {
        super(image);
        addExposedPort(MySQL_PORT);
        addFixedExposedPort(MySQL_PORT, 3306);
    }

    public Integer getPort() {
        return getMappedPort(MySQL_PORT);
    }
}
