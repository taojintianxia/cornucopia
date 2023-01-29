package com.github.taojintianxia.cornucopia.awaitility.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
public final class MessageEmulator {

    @Getter
    private static final MessageEmulator INSTANCE = new MessageEmulator();

    @SneakyThrows
    public void sendMessage( User user ) {
        log.info("Sending message to user: {}", user);
        Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
    }
}
