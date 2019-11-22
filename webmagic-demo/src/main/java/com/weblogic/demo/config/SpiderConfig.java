package com.weblogic.demo.config;

import com.weblogic.demo.constant.JobConstant;
import com.weblogic.demo.handler.JobResultHandler;
import com.weblogic.demo.job.JobPasser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.ProxyProvider;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

/**
 * @program mall
 * @description:
 * @author: wangjian
 * @create: 2019/11/21 16:11:48
 */
@Configuration
public class SpiderConfig {

    @Autowired
    private JobPasser jobPasser;

    @Autowired
    private JobResultHandler jobResultHandler;

    @Bean
    public Spider getSpider() {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(new Proxy("39.96.210.247", 90)));
        return new Spider(jobPasser)
                .addUrl(JobConstant.URL)
                .setDownloader(httpClientDownloader)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(10 * 10000)))
                .addPipeline(jobResultHandler)
                .thread(5);
    }
}
