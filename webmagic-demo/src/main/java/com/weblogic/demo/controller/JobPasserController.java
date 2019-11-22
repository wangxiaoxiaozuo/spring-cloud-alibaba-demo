package com.weblogic.demo.controller;

import com.weblogic.demo.service.JobPasserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.codecraft.webmagic.Spider;

/**
 * @program mall
 * @description:
 * @author: wangjian
 * @create: 2019/11/21 15:46:24
 */
@RestController
@RequestMapping("/spider")
public class JobPasserController {


    @Autowired
    private JobPasserService jobPasserService;


    @GetMapping("/start")
    public String startSpider() {
        jobPasserService.startJob();
        return "Spider is start ....";
    }

    @GetMapping("/stop")
    public String stopSpider() {
        jobPasserService.stopJob();
        return "Spider is stop ....";
    }


}
