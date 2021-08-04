package com.github.taojintianxia.cornucopia.databasebenchmark.executor;

import com.github.taojintianxia.cornucopia.databasebenchmark.executor.param.ExecutorParam;

public interface BenchmarkExecutor {

    void statisticize();

    void execute(ExecutorParam executorParam);
}
