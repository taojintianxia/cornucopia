package com.github.taojintianxia.cornucopia.springboot.application;

import com.github.taojintianxia.cornucopia.springboot.customizedstarter.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nianjun Sun
 * @date 2020/3/9 18:07
 */
@RestController
@SpringBootApplication
public class HelloApplication {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/")
    public String sayHello() {
        return helloService.sayHello();
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }
}
