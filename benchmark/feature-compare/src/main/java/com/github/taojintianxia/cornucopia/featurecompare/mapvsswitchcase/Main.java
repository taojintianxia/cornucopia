package com.github.taojintianxia.cornucopia.featurecompare.mapvsswitchcase;

import com.google.common.base.Stopwatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    private final static Map<TreeCacheEvent.Type, String> testMap = new HashMap<>();

    private final static int LOOP_COUNT = 100000000;

    public static void main( String... args ) {
        testMap.put(TreeCacheEvent.Type.NODE_ADDED, "NODE_ADDED");
        testMap.put(TreeCacheEvent.Type.NODE_UPDATED, "NODE_UPDATED");
        testMap.put(TreeCacheEvent.Type.NODE_REMOVED, "NODE_REMOVED");
        List<TreeCacheEvent.Type> typeList = Arrays.asList(TreeCacheEvent.Type.NODE_ADDED,TreeCacheEvent.Type.NODE_UPDATED,TreeCacheEvent.Type.NODE_REMOVED);
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < LOOP_COUNT ; i++){
            getByMap(typeList.get(threadLocalRandom.nextInt(3)));
        }
        System.out.println("get by map takes : " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        stopwatch = stopwatch.createStarted();
        for (int i = 0; i < LOOP_COUNT ; i++){
            getBySwitchCase(typeList.get(threadLocalRandom.nextInt(3)));
        }
        System.out.println("get by switch takes : " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    private static String getByMap( TreeCacheEvent.Type type ) {
        return testMap.get(type);
    }

    private static String getBySwitchCase( TreeCacheEvent.Type type ) {
        switch (type) {
            case NODE_ADDED:
                return "NODE_ADDED";
            case NODE_UPDATED:
                return "NODE_UPDATED";
            case NODE_REMOVED:
                return "NODE_REMOVED";
            default:
                return "DEFAULT";
        }
    }
}
