package com.log.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @program mall
 * @description:
 * @author: wangjian
 * @create: 2019/11/20 15:18:22
 */
@Configuration
@EnableAspectJAutoProxy
@ConditionalOnClass(SpringBootApplication.class)
public class LogxConfig {

}
