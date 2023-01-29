package com.github.taojintianxia.cornucopia.awaitility.demo1;

import com.github.taojintianxia.cornucopia.awaitility.common.MessageEmulator;
import com.github.taojintianxia.cornucopia.awaitility.common.User;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;

@Slf4j
public class DemoTest {
    
    @Test
    public void testSendMessage() {
        MessageEmulator emulator = MessageEmulator.getInstance();
        emulator.sendMessage(new User("taojintianxia"), 1000);
        assertEquals(0, emulator.getUserCount());
    }
    
    @Test
    @SneakyThrows
    public void testSendMessageWithSleep() {
        MessageEmulator emulator = MessageEmulator.getInstance();
        emulator.sendMessage(new User("taojintianxia"), 1000);
        await().atMost(5, SECONDS).until(() -> emulator.getUserCount() == 1);
        assertEquals(1, emulator.getUserCount());
    }
}
