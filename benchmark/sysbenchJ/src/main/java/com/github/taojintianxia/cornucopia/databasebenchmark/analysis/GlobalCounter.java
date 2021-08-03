package com.github.taojintianxia.cornucopia.databasebenchmark.analysis;

import java.util.concurrent.atomic.AtomicLong;

public class GlobalCounter {

    private static final AtomicLong atomicLong = new AtomicLong(0);

    private static final GlobalCounter INSTANCE = new GlobalCounter();

    private GlobalCounter() {
    }

    public static GlobalCounter getInstance() {
        return INSTANCE;
    }

    public void plus() {
        atomicLong.incrementAndGet();
    }

    public long getCount() {
        return atomicLong.get();
    }
}
