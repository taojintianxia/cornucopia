package com.github.taojintianxia.cornucopia.databasebenchmark.executor;

import com.github.taojintianxia.cornucopia.databasebenchmark.executor.param.BaseBenchmarkParam;
import com.github.taojintianxia.cornucopia.databasebenchmark.script.ScriptHolder;
import com.github.taojintianxia.cornucopia.databasebenchmark.script.inernal.BenchmarkPrepare;
import com.github.taojintianxia.cornucopia.databasebenchmark.statistic.BenchmarkStatistics;
import lombok.Setter;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

@Setter
public class DefaultBenchmarkExecutor implements BenchmarkExecutor, Runnable {

    private DataSource dataSource;

    private BaseBenchmarkParam baseBenchmarkParam;

    private Map<Integer, PreparedStatement> statementMap = new HashMap<>();

    @Override
    public void run() {

    }

    @SneakyThrows
    private void generatePrepareStatement() {
        Connection connection = dataSource.getConnection();
        String sql = ScriptHolder.getInstance().getByCommand(baseBenchmarkParam.getCommand()).getScriptContent();
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
    private void prepare() {
        Connection connection = dataSource.getConnection();
        int tables = baseBenchmarkParam.getTables();
        for (int i = 1; i <= tables; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(String.format(new BenchmarkPrepare().getScriptContent(), i));
            preparedStatement.execute();
        }


    }

    private void cleanup() {

    }
}
