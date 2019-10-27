package com.github.taojintianxia.testcontainersjavaexample.mongodb;

import com.github.taojintianxia.testcontainersjavaexample.mongodb.container.MongoDbContainer;
import org.junit.Test;

import java.io.IOException;
import java.net.Socket;


public class MongoDbContainerTest {

    @Test
    public void containerStartsAndPublicPortIsAvailable() {
        try (MongoDbContainer container = new MongoDbContainer()) {
            container.start();
            assertThatPortIsAvailable(container);
        }
    }

    private void assertThatPortIsAvailable(MongoDbContainer container) {
        try {
            new Socket(container.getContainerIpAddress(), container.getPort());
        } catch (IOException e) {
            throw new AssertionError("The expected port " + container.getPort() + " is not available!");
        }
    }

}
