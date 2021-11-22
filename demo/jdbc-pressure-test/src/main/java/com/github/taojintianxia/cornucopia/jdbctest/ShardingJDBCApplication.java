package com.github.taojintianxia.cornucopia.jdbctest;

import com.github.taojintianxia.cornucopia.jdbctest.factory.BenchmarkFactory;
import com.github.taojintianxia.cornucopia.jdbctest.statement.SysbenchBenchmark;
import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.sql.DataSource;

public class ShardingJDBCApplication {

    private static CopyOnWriteArrayList<Long> executionTimeList = new CopyOnWriteArrayList();

    public static int TABLE_SIZE;

    public static void main( String... args ) throws SQLException, IOException {
        paramCheck();
        String configurationFile = System.getProperty("conf");
        int time = Integer.parseInt(System.getProperty("time"));
        int thread = Integer.parseInt(System.getProperty("thread"));
        String scriptName = System.getProperty("script");
        TABLE_SIZE = Integer.parseInt(System.getProperty("table-size"));

        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(new File(configurationFile));
        ExecutorService service = Executors.newFixedThreadPool(thread);
        for (int i = 0; i < thread; i++) {
            DataSourceExecutor dataSourceExecutor = new DataSourceExecutor();
            dataSourceExecutor.setBenchmark(BenchmarkFactory.getBenchmarkByName(scriptName, dataSource.getConnection()));
            service.submit(dataSourceExecutor);
        }
        Timer timer = new Timer();
        ThreadPoolTimerTask threadPoolTimerTask = new ThreadPoolTimerTask();
        threadPoolTimerTask.setExecutorService(service);
        timer.schedule(threadPoolTimerTask, time * 1000);
        System.out.println("Total execution count : " + executionTimeList.size());
        System.out.println("Average time is : " + getAverageTime(executionTimeList));
        System.out.println("TPS is : " + executionTimeList.size() / time);
    }

    private static long getAverageTime( CopyOnWriteArrayList<Long> executionTimeList ) {
        long timeTotal = 0;
        for (long each : executionTimeList) {
            timeTotal += each;
        }
        return timeTotal / executionTimeList.size();
    }

    private static void paramCheck() {
        if (System.getProperty("conf") == null) {
            throw new RuntimeException("\"-Dcon\" has not been set");
        }
        if (System.getProperty("time") == null) {
            throw new RuntimeException("\"-Dtime\" has not been set");
        }
        if (System.getProperty("thread") == null) {
            throw new RuntimeException("\"-Dthread\" has not been set");
        }
        if (System.getProperty("table-size") == null) {
            throw new RuntimeException("\"-Dtable-size\" has not been set");
        }
        if (System.getProperty("script") == null) {
            throw new RuntimeException("\"-Dscript\" has not been set");
        }
    }

    private static class ThreadPoolTimerTask extends TimerTask {

        private ExecutorService executorService;

        public void setExecutorService( ExecutorService executorService ) {
            this.executorService = executorService;
        }

        @Override
        public void run() {
            System.out.println("----------------------------------------------------------");
            System.out.println("all tests finished");
            System.out.println("----------------------------------------------------------");
            executorService.shutdownNow();
        }
    }


    private static class DataSourceExecutor implements Runnable {

        private SysbenchBenchmark sysbenchBenchmark;

        public void setBenchmark( SysbenchBenchmark sysbenchBenchmark ) throws SQLException {
            this.sysbenchBenchmark = sysbenchBenchmark;
        }

        @Override
        public void run() {
            int i = 0;
            while (!Thread.interrupted()) {
                try {
                    long start = System.currentTimeMillis();
                    sysbenchBenchmark.execute();
                    executionTimeList.add(System.currentTimeMillis() - start);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
