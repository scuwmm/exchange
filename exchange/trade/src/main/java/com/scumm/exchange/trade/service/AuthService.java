package com.scumm.exchange.trade.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
//服务提供者提供的服务名称，即 application.name
@FeignClient(value = "AUTH")
public interface AuthService {

    @RequestMapping(value = "/say_hello", method = RequestMethod.GET)
    public String auth();
}
