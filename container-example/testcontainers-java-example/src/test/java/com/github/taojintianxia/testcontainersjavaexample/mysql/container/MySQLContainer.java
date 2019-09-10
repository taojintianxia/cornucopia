package com.github.taojintianxia.testcontainersjavaexample.mysql.container;

import org.testcontainers.containers.GenericContainer;

/**
 * @author Nianjun Sun
 * @date 2019/9/10 12:56
 */
public class MySQLContainer extends GenericContainer<MySQLContainer> {

    public static final int MySQL_PORT = 13306;

    public static final String DEFAULT_IMAGE_AND_TAG = "mysql:5.7";

    public MySQLContainer() {
        this(DEFAULT_IMAGE_AND_TAG);
    }

    public MySQLContainer(String image) {
        super(image);
        addExposedPort(MySQL_PORT);
    }

    public Integer getPort() {
        return getMappedPort(MySQL_PORT);
    }
}
