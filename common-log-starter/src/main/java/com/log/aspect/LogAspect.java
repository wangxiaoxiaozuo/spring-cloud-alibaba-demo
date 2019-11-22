package com.log.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @program mall
 * @description: Logx 日志切面
 * @author: wangjian
 * @create: 2019/11/20 15:17:51
 */
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.log.annontation.MethodLogX)")
    public void getPoincut() {}


    @Around("getPoincut()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        //获取方法名称
        MethodInvocationProceedingJoinPoint invocation =  (MethodInvocationProceedingJoinPoint)pjp;
        MethodSignature methodSignature = (MethodSignature)invocation.getSignature();
        Object retVal = pjp.proceed();
        long endTime = System.currentTimeMillis();
        log.info("[{}] =========> 执行耗时: {} 毫秒", methodSignature.getMethod().getName(), endTime - startTime);
        return retVal;
    }

}
