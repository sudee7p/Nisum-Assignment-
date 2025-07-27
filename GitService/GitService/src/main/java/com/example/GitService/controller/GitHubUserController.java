package com.example.GitService.controller;


import com.example.GitService.service.GitHubUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/github")
public class GitHubUserController {

    @Autowired
    private GitHubUserService gitHubUserService;

    @GetMapping("/users/{username}")
    public Mono<String> getGitHubUser(@PathVariable String username) {
        return gitHubUserService.getUserDetails(username);
    }
}

