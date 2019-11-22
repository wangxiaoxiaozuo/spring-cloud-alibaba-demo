package com.alibaba.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program mall
 * @description:
 * @author: wangjian
 * @create: 2019/11/14 17:09:39
 */
@RestController
public class ProviderController {


    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

    @GetMapping("/hello")
    public String getConfig() {
        StringBuilder stringBuilder = new StringBuilder();
        String userName = applicationContext.getEnvironment().getProperty("user.name");
        return stringBuilder.append("Hello Nacos config ").append(userName).toString();
    }
}
