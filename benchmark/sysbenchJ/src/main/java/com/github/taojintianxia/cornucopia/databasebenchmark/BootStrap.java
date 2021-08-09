package com.github.taojintianxia.cornucopia.databasebenchmark;

import com.github.taojintianxia.cornucopia.databasebenchmark.executor.ExecutorParamExtractor;
import com.github.taojintianxia.cornucopia.databasebenchmark.executor.service.BenchmarkExecutorService;

public class BootStrap {

    public static void main( String... args ) {
        BenchmarkExecutorService benchmarkExecutorService = new BenchmarkExecutorService();
        benchmarkExecutorService.execute(ExecutorParamExtractor.extract(args));
    }
}
