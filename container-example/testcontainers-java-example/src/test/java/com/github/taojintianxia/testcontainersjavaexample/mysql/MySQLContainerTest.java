package com.github.taojintianxia.testcontainersjavaexample.mysql;

import com.github.taojintianxia.testcontainersjavaexample.mysql.container.MySQLContainer;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;

/**
 * @author Nianjun Sun
 * @date 2019/9/10 13:06
 */
public class MySQLContainerTest {

    @Test
    public void containerStartsAndPublicPortIsAvailable() {
        try (MySQLContainer container = new MySQLContainer()) {
            container.start();
            assertThatPortIsAvailable(container);
        }
    }

    private void assertThatPortIsAvailable(MySQLContainer container) {
        try {
            new Socket(container.getContainerIpAddress(), container.getPort());
        } catch (IOException e) {
            throw new AssertionError("The expected port " + container.getPort() + " is not available!");
        }
    }

}
