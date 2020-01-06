package com.github.taojintianxia.cornucopia.shardingsphere.mybatisexample;

import com.github.taojintianxia.cornucopia.shardingsphere.mybatisexample.mapper.StateMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Nianjun Sun
 * @date 2020/1/6 12:17
 */
@SpringBootApplication
public class MybatisExampleApplication implements CommandLineRunner {

    private final StateMapper stateMapper;

    public MybatisExampleApplication(StateMapper stateMapper) {
        this.stateMapper = stateMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.stateMapper.findByState("CA"));
    }
}
