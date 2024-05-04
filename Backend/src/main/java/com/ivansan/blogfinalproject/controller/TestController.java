package com.ivansan.blogfinalproject.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Hidden
public class TestController {

    // Test controller to check if the application is running
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

}
