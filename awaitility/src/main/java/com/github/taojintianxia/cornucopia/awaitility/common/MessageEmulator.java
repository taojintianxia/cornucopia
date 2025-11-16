package com.github.taojintianxia.cornucopia.awaitility.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Getter
@RequiredArgsConstructor
public final class MessageEmulator {
    
    private int userCount = 0;
    
    private static final MessageEmulator INSTANCE = new MessageEmulator();
    
    public static MessageEmulator getInstance() {
        return INSTANCE;
    }
    
    private void increaseUserCount() {
        ++userCount;
    }
    
    private void runAsync(final User user, final long sleepTime) {
        CompletableFuture.runAsync(() -> {
            try {
                log.info("Sending message to user: {}", user);
                Thread.sleep(sleepTime);
                increaseUserCount();
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
        });
    }
    
    public void sendMessage(final User user, final long sleepTime) {
        runAsync(user, sleepTime);
    }
}
