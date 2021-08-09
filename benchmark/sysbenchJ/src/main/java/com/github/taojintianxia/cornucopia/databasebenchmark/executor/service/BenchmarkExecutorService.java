package com.github.taojintianxia.cornucopia.databasebenchmark.executor.service;

import com.github.taojintianxia.cornucopia.databasebenchmark.constants.BenchmarkConstant;
import com.github.taojintianxia.cornucopia.databasebenchmark.executor.DefaultBenchmarkExecutor;
import com.github.taojintianxia.cornucopia.databasebenchmark.executor.param.BaseBenchmarkParam;
import com.github.taojintianxia.cornucopia.databasebenchmark.executor.param.MySQLBenchmarkParam;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class BenchmarkExecutorService {

    @SneakyThrows
    public void execute( BaseBenchmarkParam baseBenchmarkParam ) {
        HikariDataSource hikariDataSource = new HikariDataSource(generateHikariConfig(baseBenchmarkParam));
        int threads = baseBenchmarkParam.getThreads();
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        for (int i = 0; i < threads; i++) {
            DefaultBenchmarkExecutor defaultBenchmarkExecutor = new DefaultBenchmarkExecutor();
            defaultBenchmarkExecutor.setDataSource(hikariDataSource);
            defaultBenchmarkExecutor.setBaseBenchmarkParam(baseBenchmarkParam);
            executor.submit(defaultBenchmarkExecutor);
        }

        new Timer("timer").schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("start to shut down thread pool");
                executor.shutdownNow();
            }
        }, baseBenchmarkParam.getTime() * 1000L);
    }

    private HikariConfig generateHikariConfig( BaseBenchmarkParam baseBenchmarkParam ) {
        HikariConfig hikariConfig = new HikariConfig();
        if (BenchmarkConstant.MYSQL_DB_DRIVER.equals(baseBenchmarkParam.getDriver())) {
            MySQLBenchmarkParam mySQLBenchmarkParam = (MySQLBenchmarkParam) baseBenchmarkParam;
            hikariConfig.setUsername(mySQLBenchmarkParam.getMysqlUser());
            hikariConfig.setPassword(mySQLBenchmarkParam.getMysqlPassword());
            hikariConfig.setJdbcUrl(String.format("jdbc:%s://%s:%s/%s", mySQLBenchmarkParam.getDriver(), mySQLBenchmarkParam.getMysqlHost(),
                                                  mySQLBenchmarkParam.getMysqlPort(), mySQLBenchmarkParam.getMysqlDb()));
        } else {
            //TODO: for pgsql
        }

        return hikariConfig;
    }
}
