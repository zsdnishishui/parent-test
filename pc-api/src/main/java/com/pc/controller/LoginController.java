package com.pc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    String redirectUrl = "http://localhost:8081/login/loginCode";
    String clientId = "client";
    String clientSecret = "secret";

    @Autowired
    private RestTemplate restTemplate; //RestTemplate 是一种简单便捷的访问 restful 服务模板类，是 Spring 提供的用于访问 Rest 服务的客户端模板工具集，提供了多种便捷访问远程 HTTP 服务的方法
    @RequestMapping("/loginSso")
    public String loginSso( HttpServletResponse response) {
//        String redirectUrl = "http://localhost:8081/login/loginCode";
//        String redirectUrl = "http://wwww.baidu.com";
//        String clientId = "client";
        String url = "http://localhost:8083/oauth/authorize?client_id="+clientId+"&redirect_uri="+redirectUrl+"&response_type=code";
        return "redirect:"+url;
    }

    @GetMapping("/loginCode")
    public ResponseEntity<String> hello(String code) {
        if (code != null) {
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("code", code);
            map.add("client_id", clientId);
            map.add("client_secret", clientSecret);
            map.add("grant_type", "authorization_code");
            Map<String,String> resp = restTemplate.postForObject("http://localhost:8083/oauth/token", map, Map.class);
            String access_token = resp.get("access_token");
            System.out.println(access_token);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + access_token);
            HttpEntity<Object> httpEntity = new HttpEntity<>(headers);
            ResponseEntity<String> entity = restTemplate.exchange("http://localhost:8084/base/world", HttpMethod.GET, httpEntity, String.class);
            return entity;
        }
        return null;
    }
}
