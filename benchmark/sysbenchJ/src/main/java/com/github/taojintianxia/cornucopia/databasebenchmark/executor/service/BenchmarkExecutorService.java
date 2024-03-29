package com.github.taojintianxia.cornucopia.databasebenchmark.executor.service;

import com.github.taojintianxia.cornucopia.databasebenchmark.constants.BenchmarkConstant;
import com.github.taojintianxia.cornucopia.databasebenchmark.executor.BenchmarkExecutorManager;
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
        if (BenchmarkConstant.COMMAND_PREPARE.equals(baseBenchmarkParam.getCommand())) {
            new BenchmarkExecutorManager(hikariDataSource, baseBenchmarkParam).prepare();
            return;
        }
        if (BenchmarkConstant.COMMAND_CLEAN.equals(baseBenchmarkParam.getCommand())) {
            new BenchmarkExecutorManager(hikariDataSource, baseBenchmarkParam).cleanup();
            return;
        }
        int threads = baseBenchmarkParam.getThreads();
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        for (int i = 0; i < threads; i++) {
            BenchmarkExecutorManager defaultBenchmarkExecutor = new BenchmarkExecutorManager();
            defaultBenchmarkExecutor.setDataSource(hikariDataSource);
            defaultBenchmarkExecutor.setBaseBenchmarkParam(baseBenchmarkParam);
            executor.submit(defaultBenchmarkExecutor);
        }

        new Timer("termination_timer").schedule(new TimerTask() {
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
            String password = mySQLBenchmarkParam.getMysqlPassword();
            hikariConfig.setUsername(mySQLBenchmarkParam.getMysqlUser());
            hikariConfig.setPassword(password.substring(1, password.length() - 1));
            hikariConfig.setJdbcUrl(String.format("jdbc:%s://%s:%s/%s", mySQLBenchmarkParam.getDriver(), mySQLBenchmarkParam.getMysqlHost(),
                                                  mySQLBenchmarkParam.getMysqlPort(), mySQLBenchmarkParam.getMysqlDb()));
        } else {
            //TODO: for pgsql
        }
        return hikariConfig;
    }
}
