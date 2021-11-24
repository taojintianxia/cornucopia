package com.github.taojintianxia.cornucopia.jdbctest.executor;

import com.github.taojintianxia.cornucopia.jdbctest.statement.SysbenchBenchmark;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.ConcurrentLinkedQueue;

@RequiredArgsConstructor
public class BenchmarkExecutor implements Runnable {

    private final SysbenchBenchmark sysbenchBenchmark;

    private final ConcurrentLinkedQueue<Long> queue;

    @Override
    @SneakyThrows
    public void run() {
        while (!Thread.interrupted()) {
            long start = System.currentTimeMillis();
            sysbenchBenchmark.execute();
            queue.add(System.currentTimeMillis() - start);
        }
    }
}
