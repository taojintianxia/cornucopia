package com.github.taojintianxia.cornucopia.okhttp.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nianjun Sun
 */
@RestController
public class HttpServerController {

    @GetMapping("/server/sayHello")
    public String sayHello() {
        return "BigBoss";
    }
}
