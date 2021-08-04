package com.github.taojintianxia.cornucopia.databasebenchmark.statistic;

public class GlobalCounter {

    private static final GlobalCounter INSTANCE = new GlobalCounter();

    public static GlobalCounter getInstance() {
        return INSTANCE;
    }

}
