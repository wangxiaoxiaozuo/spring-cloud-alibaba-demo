package com.weblogic.demo;

import com.weblogic.demo.config.SpiderConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program mall
 * @description:
 * @author: wangjian
 * @create: 2019/11/21 09:56:30
 */
@SpringBootApplication
public class WebMagicApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebMagicApplication.class, args);

    }
}
