package com.pc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("session")
public class SpringSessionController {
    @RequestMapping("getTestKey")
    public String  getMsg(HttpSession session) {

        String msg=(String) session.getAttribute("TestKey");
        return msg+"|sessionId="+session.getId();
    }


    @RequestMapping("setTestKey")
    public String  setMsg(HttpSession session) {

        session.setAttribute("TestKey", "Hello World!");
        return "ok|sessionId="+session.getId();
    }
}