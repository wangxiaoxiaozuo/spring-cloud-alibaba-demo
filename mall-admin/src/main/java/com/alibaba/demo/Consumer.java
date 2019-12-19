package com.alibaba.demo;

import com.alibaba.demo.service.fallback.ConsumerServiceFallback;
import com.log.aspect.LogAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @program mall
 * @description:
 * @author: wangjian
 * @create: 2019/11/14 16:21:20
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Consumer {

    public static void main(String[] args) {
        SpringApplication.run(Consumer.class, args);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean
    public LogAspect getLog() {
        return new LogAspect();
    }

}
