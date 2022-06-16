package com.scumm.exchange.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("")
public class HelloController {

    @RequestMapping("say_hello")
    public Object sayHello() {
        return "hello world";
    }
}
