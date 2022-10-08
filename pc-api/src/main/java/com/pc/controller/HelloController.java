package com.pc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/base")
public class HelloController {

    @GetMapping("/hello")
    public String hello( HttpServletResponse response) {
        Cookie cookie = new Cookie("name_test","value_test");//创建新cookie
        cookie.setMaxAge(5 * 60);// 设置存在时间为5分钟
        cookie.setPath("/");//设置作用域
        response.addCookie(cookie);//将cookie添加到response的cookie数组中返回给客户端
         return "hello";
    }

    @GetMapping("/world")
    public String world( HttpServletResponse response) {
        return "world";
    }
}
