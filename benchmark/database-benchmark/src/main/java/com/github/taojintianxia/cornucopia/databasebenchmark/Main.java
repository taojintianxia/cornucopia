package com.github.taojintianxia.cornucopia.databasebenchmark;

import com.github.taojintianxia.cornucopia.databasebenchmark.analysis.GlobalCounter;
import com.github.taojintianxia.cornucopia.databasebenchmark.context.EnvironmentContext;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.SneakyThrows;

import java.io.File;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    @SneakyThrows
    public static void main( String... args ) {
        String configFileName = args[0];
        Objects.requireNonNull(configFileName, "please specify the config file");
        File configFile = new File(System.getProperty("user.dir") + File.pathSeparator + configFileName);
        if (!configFile.exists()) {
            throw new RuntimeException(String.format("config file %s doesn't exist !", configFileName));
        }

        //TODO make it from config file or system parameters
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/sbtest");
        config.setUsername("root");
        config.setPassword("root");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource dataSource = new HikariDataSource(config);
        int thread = Integer.parseInt(EnvironmentContext.getInstance().getBenchmarkMap().get("thread"));
        int benchmarkTime = Integer.parseInt(EnvironmentContext.getInstance().getBenchmarkMap().get("benchmarkTime"));
        ExecutorService executor = Executors.newFixedThreadPool(thread);

        for (int i = 0; i < thread; i++) {
            PointSelectTerminal pointSelectTerminal = new PointSelectTerminal();
            pointSelectTerminal.setDataSource(dataSource);
            executor.submit(pointSelectTerminal);
        }

        new Timer("timer").schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("current qps is : " + (GlobalCounter.getInstance().getCount() / benchmarkTime));
                executor.shutdownNow();
            }
        }, benchmarkTime * 1000L);
    }
}
