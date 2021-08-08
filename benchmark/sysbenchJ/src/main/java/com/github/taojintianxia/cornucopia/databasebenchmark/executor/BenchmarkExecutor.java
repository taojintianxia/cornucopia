package com.github.taojintianxia.cornucopia.databasebenchmark.executor;

import com.github.taojintianxia.cornucopia.databasebenchmark.statistic.BenchmarkStatistics;

public interface BenchmarkExecutor {

    void prepare();

    void execute();

    BenchmarkStatistics getStatistics();

    void clean();
}
