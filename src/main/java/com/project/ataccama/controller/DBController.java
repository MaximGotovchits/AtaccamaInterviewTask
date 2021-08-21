package com.project.ataccama.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBController {
    @RequestMapping("/")
    public String select() {
        return "hello";
    }
}
