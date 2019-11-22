package com.log.config;

import com.log.annontation.MethodLog;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

/**
 * @program mall
 * @description: 定义一个日志切面
 * @author: wangjian
 * @create: 2019/11/20 14:49:34
 */
@Configuration
@ConditionalOnClass(SpringBootApplication.class)
public class MethodLogConfig extends AbstractPointcutAdvisor implements InitializingBean {

    private Pointcut pointcut;

    private Advice advice;

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.pointcut = new AnnotationMatchingPointcut(null, MethodLog.class);
        this.advice = new MethodLogAdvice();
    }
}
