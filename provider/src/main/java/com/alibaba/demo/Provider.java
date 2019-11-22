package com.alibaba.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program mall
 * @description:
 * @author: wangjian
 * @create: 2019/11/14 15:49:26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Provider {

    public static void main(String[] args) {
        SpringApplication.run(Provider.class, args);
    }



}
