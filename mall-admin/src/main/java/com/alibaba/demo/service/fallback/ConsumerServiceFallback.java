package com.alibaba.demo.service.fallback;

import com.alibaba.demo.service.ConsumerService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program mall
 * @description:
 * @author: wangjian
 * @create: 2019/11/15 14:52:32
 */
@Component
public class ConsumerServiceFallback implements ConsumerService {

    @Override
    public String echo(@PathVariable("applicationName") String applicationName) {
        return "您请求的服务已经不工作了";
    }
}
