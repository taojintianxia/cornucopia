package com.github.taojintianxia.cornucopia.databasebenchmark;

import com.github.taojintianxia.cornucopia.databasebenchmark.executor.ExecutorParamExtractor;
import com.github.taojintianxia.cornucopia.databasebenchmark.executor.param.BaseBenchmarkParam;

public class BootStrap {

    public static void main( String... args ) {
        BaseBenchmarkParam baseBenchmarkParam = ExecutorParamExtractor.extract(args);
    }
}
