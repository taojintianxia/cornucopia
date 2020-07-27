package com.github.taojintianxia.cornucopia.springboot.dubbo.simple.consumer.controller;

import com.github.taojintianxia.cornucopia.springboot.dubbo.simple.api.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nianjun Sun
 */
@RestController
public class DemoController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @DubboReference(version = "${demo.service.version}", url = "${demo.service.url}")
    private DemoService demoService;

    @Bean
    public ApplicationRunner runner() {
        return args -> logger.info(demoService.sayHello("mercyblitz"));
    }

    @GetMapping("sayHello")
    public String sayHello(@RequestParam String name){
        System.out.println("SENDING DATA FROM CONSUMER");
        return demoService.sayHello(name);
    }
}
