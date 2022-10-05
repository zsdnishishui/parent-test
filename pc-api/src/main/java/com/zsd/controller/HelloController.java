package com.zsd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class HelloController {


    @GetMapping("/hello")
    public String world() {
         System.out.println("world");
         return "world";
    }
}
