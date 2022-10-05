package com.zsd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class HelloController {


    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
         return "hello";
    }
}
