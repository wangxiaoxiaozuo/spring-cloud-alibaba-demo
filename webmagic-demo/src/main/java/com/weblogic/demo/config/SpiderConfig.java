package com.weblogic.demo.config;

import com.weblogic.demo.constant.JobConstant;
import com.weblogic.demo.handler.JobResultElasticSearchHandler;
import com.weblogic.demo.handler.JobResultMySqlHandler;
import com.weblogic.demo.job.JobPasser;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.proxy.Proxy;
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

    @Bean
    public Spider getSpider(JobResultMySqlHandler jobResultMySqlHandler, JobResultElasticSearchHandler jobResultElasticSearchHandler) {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(new Proxy("39.96.210.247", 90)));
        return new Spider(jobPasser)
                .addUrl(JobConstant.URL)
//                .setDownloader(httpClientDownloader)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(10 * 10000)))
                .addPipeline(jobResultMySqlHandler)
                .addPipeline(jobResultElasticSearchHandler)
                .thread(5);
    }
}
