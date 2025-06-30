package com.example.demo.autoconfig;

import com.example.demo.service.service;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreeterAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public service autoConfiguredGreeter() {
        return name -> "Hello from Auto-Configuration, " + name + "!";
    }
}
