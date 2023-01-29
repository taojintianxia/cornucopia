package com.github.taojintianxia.cornucopia.awaitility.common;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@ToString
public class User {

    private final int id = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);

    private final String name;
}
