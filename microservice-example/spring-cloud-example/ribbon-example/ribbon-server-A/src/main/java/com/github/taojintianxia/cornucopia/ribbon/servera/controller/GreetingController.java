package com.github.taojintianxia.cornucopia.ribbon.servera.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nianjun Sun
 * @date 2020/1/15 19:45
 */

@RestController
public class GreetingController {

    @RequestMapping(value = "/greeting")
    public String greet() {
        return "service 1 is greeting";
    }

    @RequestMapping(value = "/")
    public String home() {
        System.out.println("Access /");
        return "Hi!";
    }
}
