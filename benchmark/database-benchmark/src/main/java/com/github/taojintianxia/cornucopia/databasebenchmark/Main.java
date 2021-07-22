package com.github.taojintianxia.cornucopia.databasebenchmark;

import com.github.taojintianxia.cornucopia.databasebenchmark.analysis.GlobalCounter;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.SneakyThrows;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    @SneakyThrows
    public static void main( String... args ) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/sbtest");
        config.setUsername("root");
        config.setPassword("root");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource dataSource = new HikariDataSource(config);
        int thread = Integer.parseInt(EnvironmentContext.getInstance().getBenchmarkMap().get("thread"));
        ExecutorService executor = Executors.newFixedThreadPool(thread);

        for (int i = 0; i < 10; i++) {
            Terminal terminal = new Terminal();
            terminal.setDataSource(dataSource);
            executor.submit(terminal);
        }

        new Timer("timer").schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("current count is : " + GlobalCounter.getInstance().getCount());
                executor.shutdownNow();
            }
        }, 10000);
    }
}
