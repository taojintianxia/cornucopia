package com.github.taojintianxia.cornucopia.databasebenchmark;

import com.github.taojintianxia.cornucopia.databasebenchmark.analysis.GlobalCounter;
import com.github.taojintianxia.cornucopia.databasebenchmark.context.EnvironmentContext;
import lombok.SneakyThrows;
import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.yaml.config.pojo.YamlRootRuleConfigurations;
import org.apache.shardingsphere.infra.yaml.config.swapper.YamlDataSourceConfigurationSwapper;
import org.apache.shardingsphere.infra.yaml.config.swapper.YamlRuleConfigurationSwapperEngine;
import org.apache.shardingsphere.infra.yaml.engine.YamlEngine;

import javax.sql.DataSource;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShardingSphereMain {

    private static final YamlRuleConfigurationSwapperEngine SWAPPER_ENGINE = new YamlRuleConfigurationSwapperEngine();

    private static final YamlDataSourceConfigurationSwapper DATASOURCE_SWAPPER = new YamlDataSourceConfigurationSwapper();


    @SneakyThrows
    public static void main( String... args ) {

        File yamlFile = new File(EnvironmentContext.class.getClassLoader().getResource("readwrite-splitting.yaml").getFile());
        YamlRootRuleConfigurations configurations = YamlEngine.unmarshal(yamlFile, YamlRootRuleConfigurations.class);
        DataSource dataSource = ShardingSphereDataSourceFactory.createDataSource(DATASOURCE_SWAPPER.swapToDataSources(configurations.getDataSources()),
                                                                                 SWAPPER_ENGINE.swapToRuleConfigurations(configurations.getRules()), configurations.getProps());
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
