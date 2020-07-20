package com.github.taojintianxia.cornucopia.ribbon.client.controller;

import com.github.taojintianxia.cornucopia.ribbon.client.configuration.ClientGreetingConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Nianjun Sun
 * @date 2020/1/15 20:00
 */
@RestController
@RibbonClient(name = "hello-world-service", configuration = ClientGreetingConfiguration.class)
public class ClientGreetingController {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "Default Service") String name) {
        String greeting = this.restTemplate.getForObject("http://hello-world-service/greeting", String.class);
        return String.format("%s, %s!", greeting, name);
    }
}
