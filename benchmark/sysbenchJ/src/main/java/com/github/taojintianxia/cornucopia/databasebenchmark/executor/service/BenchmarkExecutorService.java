package com.github.taojintianxia.cornucopia.databasebenchmark.executor.service;

import com.github.taojintianxia.cornucopia.databasebenchmark.executor.param.MySQLBenchmarkParam;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BenchmarkExecutorService {

    @SneakyThrows
    public void execute( MySQLBenchmarkParam executorParam ) {
        log.info("executing in parallel");
        log.info("executing in parallel");
        log.info("executing in parallel");
        Thread.sleep(2000);
    }
}
