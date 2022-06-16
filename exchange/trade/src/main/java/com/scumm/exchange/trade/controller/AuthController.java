package com.scumm.exchange.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("trade")
public class AuthController {

    //面向微服务编程，即通过微服务的名称来获取调用地址
    private static final String AUTH_PREFIX = "http://AUTH";

    @Autowired
    private RestTemplate restTemplate; //RestTemplate 是一种简单便捷的访问 restful 服务模板类，是 Spring 提供的用于访问 Rest 服务的客户端模板工具集，提供了多种便捷访问远程 HTTP 服务的方法

    @RequestMapping("trade_auth")
    public String checkAuth() {
        return restTemplate.getForObject(AUTH_PREFIX + "/say_hello", String.class);
    }
}
