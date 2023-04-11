package com.platzi.market.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class HelloWorldController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Never stop learning!";
    }
}
