package com.github.taojintianxia.cornucopia.benchmark.regex.mapcompare.zipcode;

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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
public class ZipcodeRegexBenchmark {
    
    private static final List<String> TARGET_DATA = new ArrayList<>();
    
    private static String rule = "" ;
    
    static {
        initRegexContent();
        TARGET_DATA.add("123456");
        TARGET_DATA.add("");
        TARGET_DATA.add("150060");
        TARGET_DATA.add("855032");
        TARGET_DATA.add("098744");
        TARGET_DATA.add("abcdef");
        TARGET_DATA.add("18600112255");
        TARGET_DATA.add("force update snapshots");
        TARGET_DATA.add("rsynch test");
        TARGET_DATA.add("artifact org");
    }
    
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(ZipcodeRegexBenchmark.class.getSimpleName()).result("result.json").resultFormat(ResultFormatType.JSON).build();
        new Runner(opt).run();
    }
    
    private static void initRegexContent() {
        String zipcodeFile = "/Users/nianjun/Work/workspace/console/console-backend/src/main/resources/static/邮政编码.txt" ;
        StringBuilder zipcodeBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(zipcodeFile))) { // 替换 "file.txt" 为要读取的文件路径
            String line;
            while ((line = reader.readLine()) != null) {
                zipcodeBuilder.append(line);
                System.out.println(line); // 按行输出文件内容
            }
        } catch (IOException ignore) {
        }
        rule = zipcodeBuilder.toString();
    }
    
    @Benchmark
    public static void testRegexBench() {
        int count = 0;
        for (String each : TARGET_DATA) {
            if (each.matches(rule)) {
                count++;
            }
        }
    }
}
