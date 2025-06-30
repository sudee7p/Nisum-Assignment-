package com.example.demo.service.impl;

import com.example.demo.service.service;
import org.springframework.stereotype.Component;

@Component
public class serviceComponent implements service {
    @Override
    public String greet(String name) {
        return "Hello from @Component, " + name + "!";
    }
}