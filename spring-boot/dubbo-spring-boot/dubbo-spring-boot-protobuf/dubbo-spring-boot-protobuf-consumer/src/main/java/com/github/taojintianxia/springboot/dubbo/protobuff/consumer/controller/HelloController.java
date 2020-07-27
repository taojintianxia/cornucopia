package com.github.taojintianxia.springboot.dubbo.protobuff.consumer.controller;

import org.apache.dubbo.demo.DemoServiceDubbo;
import org.apache.dubbo.demo.HelloReply;
import org.apache.dubbo.demo.HelloRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nianjun Sun
 */
@RestController
public class HelloController {

    private DemoServiceDubbo.IDemoService demoService;

    @GetMapping("consumer/sayHello")
    public String sayHello(){
        HelloRequest request = HelloRequest.newBuilder().setName("Hello").build();
        HelloReply reply = demoService.sayHello(request);
        return reply.getMessage();
    }
}
