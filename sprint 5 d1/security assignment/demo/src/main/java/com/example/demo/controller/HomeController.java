package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome, authenticated user!";
    }
}
