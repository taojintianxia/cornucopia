package com.github.taojintianxia.cornucopia.databasebenchmark.statistic;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BenchmarkStatistics {

    private int threads;

    private float qps;

    private float tps;

    private float latency;

    private int errors;

    private int reconnects;

}
