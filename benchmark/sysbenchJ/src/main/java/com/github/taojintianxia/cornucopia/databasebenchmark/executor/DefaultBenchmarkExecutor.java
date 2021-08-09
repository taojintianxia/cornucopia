package com.github.taojintianxia.cornucopia.databasebenchmark.executor;

import com.github.taojintianxia.cornucopia.databasebenchmark.statistic.BenchmarkStatistics;
import lombok.Setter;

import javax.sql.DataSource;

public class DefaultBenchmarkExecutor implements BenchmarkExecutor, Runnable {

    @Setter
    private DataSource dataSource;

    @Override
    public void run() {

    }

    @Override
    public BenchmarkStatistics getStatistics() {
        return null;
    }

    private void prepare() {

    }

    private void cleanup() {

    }
}
