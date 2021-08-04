package com.github.taojintianxia.cornucopia.databasebenchmark.executor;

import com.github.taojintianxia.cornucopia.databasebenchmark.executor.param.ExecutorParam;
import com.github.taojintianxia.cornucopia.databasebenchmark.script.ScriptHolder;
import lombok.SneakyThrows;

import java.sql.PreparedStatement;
import java.util.List;

public class ScriptBenchmarkExecutor implements BenchmarkExecutor {

    private List<Long> latencyList;

    private int executionCount;

    @Override
    public void statisticize() {

    }

    @Override
    @SneakyThrows
    public void execute( final ExecutorParam executorParam ) {
        long startTime = System.currentTimeMillis();
        String sql = ScriptHolder.getInstance().getByName(executorParam.getScript()).getScriptContent();
        PreparedStatement preparedStatement = executorParam.getPreparedStatement();
        preparedStatement.execute(sql);
        latencyList.add(System.currentTimeMillis() - startTime);
        executionCount++;
    }
}
