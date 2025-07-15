package com.example.Owasp.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@RestController
public class CommentController {

    @PostMapping("/comment")
    public String postComment(@RequestBody String comment) {
        return HtmlUtils.htmlEscape(comment);
    }
}