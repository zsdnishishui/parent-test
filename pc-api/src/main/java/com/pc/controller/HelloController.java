package com.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/base")
public class HelloController {
    //面向微服务编程，即通过微服务的名称来获取调用地址
    private static final String REST_URL_PROVIDER_PREFIX = "http://SSOPROVIDER"; // 使用注册到 Spring Cloud Eureka 服务注册中心中的服务，即 application.name
    @Autowired
    private RestTemplate restTemplate; //RestTemplate 是一种简单便捷的访问 restful 服务模板类，是 Spring 提供的用于访问 Rest 服务的客户端模板工具集，提供了多种便捷访问远程 HTTP 服务的方法
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
    @RequestMapping(value = "/getSsoUser")
    public String get() {
        return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/base/hello", String.class);
    }
}
