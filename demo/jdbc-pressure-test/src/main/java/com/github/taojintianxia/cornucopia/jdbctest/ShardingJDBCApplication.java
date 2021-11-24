package com.github.taojintianxia.cornucopia.jdbctest;

import com.github.taojintianxia.cornucopia.jdbctest.factory.BenchmarkFactory;
import com.github.taojintianxia.cornucopia.jdbctest.statement.SysbenchBenchmark;
import com.github.taojintianxia.cornucopia.jdbctest.validation.SysbenchParamValidator;
import lombok.SneakyThrows;
import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.sql.DataSource;

import static com.github.taojintianxia.cornucopia.jdbctest.constants.SysbenchConstant.SYSBENCH_PARAM_MAP;

public class ShardingJDBCApplication {

    private static final ConcurrentLinkedQueue<Long> concurrentLinkedQueue = new ConcurrentLinkedQueue();

    public static void main( String... args ) throws SQLException, IOException {
        SysbenchParamValidator.validateSysbenchParam();
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(new File(SYSBENCH_PARAM_MAP.get("conf")));
        ExecutorService service = Executors.newFixedThreadPool(Integer.parseInt(SYSBENCH_PARAM_MAP.get("thread")));
        for (int i = 0; i < Integer.parseInt(SYSBENCH_PARAM_MAP.get("thread")); i++) {
            DataSourceExecutor dataSourceExecutor = new DataSourceExecutor();
            dataSourceExecutor.setBenchmark(BenchmarkFactory.getBenchmarkByName(SYSBENCH_PARAM_MAP.get("script"), dataSource.getConnection()));
            service.submit(dataSourceExecutor);
        }
        Timer timer = new Timer();
        ThreadPoolTimerTask threadPoolTimerTask = new ThreadPoolTimerTask();
        threadPoolTimerTask.setExecutorService(service);
        timer.schedule(threadPoolTimerTask, Integer.parseInt(SYSBENCH_PARAM_MAP.get("time")) * 1000L);
    }

    private static void analyze() {
        System.out.println("Total execution count : " + concurrentLinkedQueue.size());
        System.out.println("Average time is : " + BigDecimal.valueOf(getAverageTime(concurrentLinkedQueue)).setScale(2, RoundingMode.HALF_UP).doubleValue());
        System.out.println("TPS is : " + concurrentLinkedQueue.size() / Integer.parseInt(SYSBENCH_PARAM_MAP.get("time")));
    }

    private static double getAverageTime( ConcurrentLinkedQueue<Long> concurrentLinkedQueue ) {
        long timeTotal = 0;
        for (long each : concurrentLinkedQueue) {
            timeTotal += each;
        }
        return timeTotal * 1.0 / concurrentLinkedQueue.size();
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
            analyze();
        }
    }

    private static class DataSourceExecutor implements Runnable {

        private SysbenchBenchmark sysbenchBenchmark;

        public void setBenchmark( SysbenchBenchmark sysbenchBenchmark ) {
            this.sysbenchBenchmark = sysbenchBenchmark;
        }

        @Override
        @SneakyThrows
        public void run() {
            while (!Thread.interrupted()) {
                long start = System.currentTimeMillis();
                sysbenchBenchmark.execute();
                concurrentLinkedQueue.add(System.currentTimeMillis() - start);
            }
        }
    }
}
