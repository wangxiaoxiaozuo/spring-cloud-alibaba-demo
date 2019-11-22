package com.alibaba.demo.service;


import com.alibaba.demo.service.fallback.ConsumerServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "provider-config", name = "provider-config",
        fallback = ConsumerServiceFallback.class)
public interface ConsumerService {

    @GetMapping("/echo/{applicationName}")
    String echo(@PathVariable("applicationName") String applicationName);

}
