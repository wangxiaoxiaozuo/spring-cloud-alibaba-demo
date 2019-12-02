package com.alibaba.demo.controller;

import com.log.annontation.MethodLog;
import com.alibaba.demo.service.ConsumerService;
import com.log.annontation.MethodLogX;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @program mall
 * @description:
 * @author: wangjian
 * @create: 2019/11/14 16:22:39
 */
@RestController
@Api(tags = "消费者测试接口")
public class NacosController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private ConsumerService consumerService;


    @Value("${spring.application.name}")
    private String appName;

    /**
     * 默认的
     */

    @GetMapping("/echo/app-name")
    public String echoAppName() {
        //Access through the combination of LoadBalanceClient and RestTemplate
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider");
        String path = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);
        System.out.println("request path:" + path);
        return restTemplate.getForObject(path, String.class);
    }

    /**
     * Feign
     */
    @GetMapping("/echo/hi")
    @MethodLog
    @MethodLogX
    @ApiOperation("测试连接服务端")
    public String sayHello() {
        return consumerService.echo(appName);
    }

}
