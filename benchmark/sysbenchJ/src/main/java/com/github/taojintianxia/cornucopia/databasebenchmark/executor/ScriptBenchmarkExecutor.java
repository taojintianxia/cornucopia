package com.github.taojintianxia.cornucopia.databasebenchmark.executor;

import com.github.taojintianxia.cornucopia.databasebenchmark.executor.param.ExecutorParam;
import com.github.taojintianxia.cornucopia.databasebenchmark.script.ScriptHolder;
import lombok.SneakyThrows;

import java.sql.PreparedStatement;

public class ScriptBenchmarkExecutor implements BenchmarkExecutor {

    @Override
    public void statisticize() {

    }

    @Override
    @SneakyThrows
    public void execute( final ExecutorParam executorParam ) {
        String sql = ScriptHolder.getInstance().getByName(executorParam.getScript()).getScriptContent();
        PreparedStatement preparedStatement = executorParam.getPreparedStatement();
        preparedStatement.execute(sql);
    }
}
