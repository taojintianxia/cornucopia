package com.github.taojintianxia.cornucopia.jdk.speedtest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

public class CopyOnWriteListAndHashMap {

    private static final CopyOnWriteArrayList<Long> COPY_ON_WRITE_ARRAY_LIST = new CopyOnWriteArrayList<>();

    private static final Map<String, List<Long>> COUNT_MAP = new HashMap<>();

    public static void main( String... args ) {

    }


    private class ListExecutor implements Runnable {

        ThreadLocalRandom random = ThreadLocalRandom.current();

        @Override
        public void run() {
            random.nextLong();
        }
    }

    private static class ThreadPoolTimerTask extends TimerTask {

        private ExecutorService executorService;

        public void setExecutorService( ExecutorService executorService ) {
            this.executorService = executorService;
        }

        @Override
        public void run() {
            System.out.println("----------------------------------------------------------");
            System.out.println("all tests finished");
            System.out.println("----------------------------------------------------------");
            executorService.shutdownNow();
        }
    }
}
