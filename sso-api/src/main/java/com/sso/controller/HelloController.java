package com.sso.controller;

import com.service.sso.StudentService;
import com.sso.pojo.SysPermission;
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

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/base")
public class HelloController {
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

    @GetMapping("/getDetail")
    public User getDetail(){
        //通过SecurityContextHolder获得当前线程上绑定的SecurityContext对象
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        return user;
    }

    @GetMapping("/index")
    public ResponseEntity<String> hello(String code) {
        if (code != null) {
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("code", code);
            map.add("client_id", "javaboy");
            map.add("client_secret", "123");
            map.add("redirect_uri", "http://localhost:8082/index.html");
            map.add("grant_type", "authorization_code");
            Map<String,String> resp = restTemplate.postForObject("http://localhost:8082/oauth/token", map, Map.class);
            String access_token = resp.get("access_token");
            System.out.println(access_token);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + access_token);
            HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
            ResponseEntity<String> entity = restTemplate.exchange("http://localhost:8082/admin/hello", HttpMethod.GET, httpEntity, String.class);
            return entity;
        }
        return null;
    }
}
