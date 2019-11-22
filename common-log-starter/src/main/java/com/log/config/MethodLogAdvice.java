package com.log.config;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @program mall
 * @description:
 * @author: wangjian
 * @create: 2019/11/20 14:58:04
 */
@Slf4j
public class MethodLogAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        //获取方法名称
        String methodName = invocation.getMethod().getName();
        Object result = invocation.proceed();
        long endTime = System.currentTimeMillis();
        log.info("{}=========>执行耗时:{}毫秒", methodName, endTime - startTime);
        return result;
    }
}
