package com.log.annontation;


import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * 日志增强版
 */
public @interface MethodLogX {


}
