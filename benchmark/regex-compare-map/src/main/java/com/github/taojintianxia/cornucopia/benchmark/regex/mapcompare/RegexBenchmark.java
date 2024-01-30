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
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 2, time = 3)
@Measurement(iterations = 3, time = 60)
@Threads(4)
@Fork(1)
@State(value = Scope.Benchmark)
@OutputTimeUnit(TimeUnit.SECONDS)
public class RegexBenchmark {
    
    private static final String RULE = "^(国家公务员|专业技术人员|职员|企业管理人员|工人|农民|学生|现役军人|自由职业者|个体经营者|无业人员|退休人员|离休人员)$" ;
    
    private static final List<String> TEST_DATA = new ArrayList<>();
    
    static {
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
    public static void testRegex() {
        int count = 0;
        for (String data : TEST_DATA) {
            if (data.matches(RULE)) {
                count++;
            }
        }
    }
}
