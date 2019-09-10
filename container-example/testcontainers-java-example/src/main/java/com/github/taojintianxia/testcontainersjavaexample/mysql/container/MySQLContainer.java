package com.github.taojintianxia.testcontainersjavaexample.mysql.container;

import com.sun.istack.internal.NotNull;

/**
 * @author Nianjun Sun
 * @date 2019/9/10 12:56
 */
public class MySQLContainer extends GenericContainer{

    public static final int MySQL_PORT = 13306;

    public static final String DEFAULT_IMAGE_AND_TAG = "mysql:5.7";

    public MySQLContainer() {
        this(DEFAULT_IMAGE_AND_TAG);
    }

    public MySQLContainer(@NotNull String image) {
        super(image);
        addExposedPort(MONGODB_PORT);
    }

    /**
     * Returns the actual public port of the internal MongoDB port ({@value MONGODB_PORT}).
     *
     * @return the public port of this container
     * @see #getMappedPort(int)
     */
    @NotNull
    public Integer getPort() {
        return getMappedPort(MONGODB_PORT);
    }

}
