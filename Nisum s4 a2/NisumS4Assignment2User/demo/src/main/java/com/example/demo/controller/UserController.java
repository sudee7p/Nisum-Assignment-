package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return new User(id, "John Doe", "john@example.com");
    }
}
