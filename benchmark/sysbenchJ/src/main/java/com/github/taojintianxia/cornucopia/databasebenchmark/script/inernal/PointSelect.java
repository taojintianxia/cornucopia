package com.github.taojintianxia.cornucopia.databasebenchmark.script.inernal;

import com.github.taojintianxia.cornucopia.databasebenchmark.executor.param.BaseBenchmarkParam;
import com.github.taojintianxia.cornucopia.databasebenchmark.script.BenchmarkScript;
import com.google.common.base.Stopwatch;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import javax.sql.DataSource;

@RequiredArgsConstructor
public class PointSelect implements BenchmarkScript {

    private final static Map<Integer, Statement> STATEMENT_MAP = new HashMap<>();

    private final static String PREPARE_SQL_TEMPLATE = "SELECT c FROM sbtest%s WHERE id=?";

    private final static String QUERY_SQL_TEMPLATE = "SELECT c FROM sbtest%s WHERE id=%s";

    private final DataSource dataSource;

    private final BaseBenchmarkParam baseBenchmarkParam;

    public String getName() {
        return "point_select";
    }

    public String getScriptContent() {
        return "SELECT c FROM sbtest%s WHERE id=?";
    }

    @SneakyThrows
    public synchronized void prepare() {
        if (!STATEMENT_MAP.isEmpty()) {
            return;
        }

        for (int i = 1; i <= baseBenchmarkParam.getThreads(); i++) {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.prepareStatement(String.format(PREPARE_SQL_TEMPLATE, i));
            STATEMENT_MAP.put(i, statement);
        }
    }

    @SneakyThrows
    public void execute() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        ThreadLocalRandom.current();
        String sql = String.format(QUERY_SQL_TEMPLATE, ThreadLocalRandom.current().nextInt(baseBenchmarkParam.getTables()), ThreadLocalRandom.current().nextInt(baseBenchmarkParam.getTableSize()));
        STATEMENT_MAP.get(ThreadLocalRandom.current().nextInt(baseBenchmarkParam.getThreads())).executeQuery(sql);
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }
}
