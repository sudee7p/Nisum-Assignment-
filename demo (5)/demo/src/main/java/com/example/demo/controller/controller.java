package com.example.demo.controller;

import com.example.demo.service.service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreeterController {

    private final service greeter;

    public GreeterController(service greeter) {
        this.greeter = greeter;
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return greeter.greet(name);
    }
}
