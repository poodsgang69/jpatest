package com.test.jpatest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UdemyController {

    @GetMapping("/hello")
    public String HelloWorld() {
        return "Hello World!";
    }
}
