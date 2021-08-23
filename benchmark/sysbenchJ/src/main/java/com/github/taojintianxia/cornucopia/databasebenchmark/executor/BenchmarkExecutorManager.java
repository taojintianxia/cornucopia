package com.github.taojintianxia.cornucopia.databasebenchmark.executor;

import com.github.taojintianxia.cornucopia.databasebenchmark.executor.param.BaseBenchmarkParam;
import com.github.taojintianxia.cornucopia.databasebenchmark.script.inernal.BenchmarkExtensionScript;
import com.github.taojintianxia.cornucopia.databasebenchmark.script.inernal.BenchmarkPrepare;
import com.github.taojintianxia.cornucopia.databasebenchmark.statistic.BenchmarkStatistics;
import com.github.taojintianxia.cornucopia.databasebenchmark.util.BenchmarkUtil;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import javax.sql.DataSource;

@Setter
@Slf4j
public class BenchmarkExecutorManager implements BenchmarkExecutor, Runnable {

    private DataSource dataSource;

    private BaseBenchmarkParam baseBenchmarkParam;

    private Map<Integer, PreparedStatement> statementMap = new HashMap<>();

    public BenchmarkExecutorManager() {
    }

    public BenchmarkExecutorManager( DataSource dataSource, BaseBenchmarkParam baseBenchmarkParam ) {
        this.dataSource = dataSource;
        this.baseBenchmarkParam = baseBenchmarkParam;
    }

    @Override
    public void run() {

    }

    @SneakyThrows
    private void generatePrepareStatement() {
        Connection connection = dataSource.getConnection();
        // TODO: fix this
//        String sql = ScriptHolder.getByCommand(dataSource, baseBenchmarkParam).getScriptContent();
        String sql = null;
        for (int i = 1; i <= baseBenchmarkParam.getTables(); i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(String.format(sql, i));
            statementMap.put(i, preparedStatement);
        }
    }

    @Override
    public BenchmarkStatistics getStatistics() {
        return null;
    }

    @SneakyThrows
    public void prepare() {
        Connection connection = dataSource.getConnection();
        int tables = baseBenchmarkParam.getTables();
        for (int i = 1; i <= tables; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(String.format(new BenchmarkPrepare().getScriptContent(), i));
            log.info("Creating table 'sbtest{}'", i);
            preparedStatement.execute();
        }
        BenchmarkExtensionScript benchmarkExtensionScript = new BenchmarkExtensionScript();
        // TODO too complicated, just create an inner class is fine
        for (int i = 1; i < baseBenchmarkParam.getTables(); i++) {
            final int currentTableSuffix = i;
            new Thread(() -> {
                PreparedStatement preparedStatement;
                try {
                    preparedStatement = connection.prepareStatement(String.format(benchmarkExtensionScript.getPrepareInsertScript(), currentTableSuffix));
                } catch (SQLException e) {
                    log.error("prepare statement error : ", e);
                    throw new RuntimeException("prepare statement error", e);
                }
                for (int j = 1; j <= baseBenchmarkParam.getTableSize(); j++) {
                    try {
                        preparedStatement.execute(generateInsertSql(currentTableSuffix, j, benchmarkExtensionScript.getPrepareScript()));
                    } catch (SQLException e) {
                        log.error("executing sql error", e);
                    }
                }
            }).start();
        }
    }

    private String generateInsertSql( int tableOrder, int id, String sqlTemplate ) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(id).append(",").append(ThreadLocalRandom.current().nextInt(1, 999999));
        stringBuilder.append(",\"").append(BenchmarkUtil.generateRandomNumberString(10)).append("\",\"")
                .append(BenchmarkUtil.generateRandomNumberString(5)).append("\"");
        return String.format(sqlTemplate, tableOrder, stringBuilder.toString());
    }

    @SneakyThrows
    public void cleanup() {
        Connection connection = dataSource.getConnection();
        int tables = baseBenchmarkParam.getTables();
        for (int i = 1; i <= tables; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(String.format(BenchmarkExtensionScript.getCleanScript(), i));
            log.info("Dropping table 'sbtest{}'...", i);
            preparedStatement.execute();
        }
    }
}
