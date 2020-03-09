package com.github.taojintianxia.cornucopia.springboot.customizedstarter.service;

/**
 * @author Nianjun Sun
 * @date 2020/3/9 16:35
 */
public class HelloService {

    private String target;

    public HelloService(String target) {
        this.target = target;
    }

    public String sayHello() {
        return "Hello " + target;
    }
}
