package com.sso.controller;

import com.service.sso.StudentService;
import com.sso.pojo.SysPermission;
import com.sso.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/base")
public class HelloController {

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

    @GetMapping("/getDetail")
    public User getDetail(){
        //通过SecurityContextHolder获得当前线程上绑定的SecurityContext对象
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        return user;
    }
}
