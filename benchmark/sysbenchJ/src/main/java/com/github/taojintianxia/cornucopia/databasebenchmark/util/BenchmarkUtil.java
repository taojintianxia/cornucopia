package com.github.taojintianxia.cornucopia.databasebenchmark.util;

import java.util.concurrent.ThreadLocalRandom;

public class BenchmarkUtil {

    public static String generateRandomNumberString( int count ) {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(threadLocalRandom.nextLong(10000000000L, 99999999999L));
            if (i == count - 1) {
                break;
            }
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
