package com.github.taojintianxia.cornucopia.benchmark.regex.mapcompare;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 2, time = 3)
@Measurement(iterations = 3, time = 60)
@Threads(4)
@Fork(1)
@State(value = Scope.Benchmark)
@OutputTimeUnit(TimeUnit.SECONDS)
public class MapBenchmark {
    
    private static final List<String> TEST_DATA = new ArrayList<>();
    
    private static final Map<String, String> RULE_MAP = new HashMap<>();
    
    private static final String RULE_NAME = "employment_status" ;
    
    static {
        RULE_MAP.put("国家公务员", RULE_NAME);
        RULE_MAP.put("专业技术人员", RULE_NAME);
        RULE_MAP.put("职员", RULE_NAME);
        RULE_MAP.put("企业管理人员", RULE_NAME);
        RULE_MAP.put("工人", RULE_NAME);
        RULE_MAP.put("农民", RULE_NAME);
        RULE_MAP.put("学生", RULE_NAME);
        RULE_MAP.put("现役军人", RULE_NAME);
        RULE_MAP.put("自由职业者", RULE_NAME);
        RULE_MAP.put("个体经营者", RULE_NAME);
        RULE_MAP.put("无业人员", RULE_NAME);
        RULE_MAP.put("退休人员", RULE_NAME);
        RULE_MAP.put("离休人员", RULE_NAME);
        TEST_DATA.add("国家公务员");
        TEST_DATA.add("测试数据-A");
        TEST_DATA.add("测试数据-B");
        TEST_DATA.add("个体经营者");
        TEST_DATA.add("18900118767");
        TEST_DATA.add("无业人员");
        TEST_DATA.add("public static void main");
        TEST_DATA.add("身份证号码");
        TEST_DATA.add("www.github.com");
        TEST_DATA.add("");
    }
    
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(MapBenchmark.class.getSimpleName()).result("result.json").resultFormat(ResultFormatType.JSON).build();
        new Runner(opt).run();
    }
    
    
    @Benchmark
    public static void testMap() {
        int mappingCount = 0;
        for (int i = 0; i < 1000; i++) {
            for (String data : TEST_DATA) {
                String result = RULE_MAP.get(data);
                if (null != result) {
                    mappingCount++;
                }
            }
        }
    }
}
