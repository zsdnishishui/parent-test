package com.sso.controller;

import com.service.sso.StudentService;
import com.sso.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SysPermissionService sysPermissionService;
    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello"+Thread.currentThread().getName());
        return "hello";
    }
    @GetMapping("/getUser")
    public String getUser() {
        return "getUser";
    }


}
