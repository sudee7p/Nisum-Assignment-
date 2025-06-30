package com.example.demo.config;

import com.example.demo.service.service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreeterConfig {

    @Bean
    public service greeter() {
        return name -> "Hello from @Bean config, " + name + "!";
    }
}

