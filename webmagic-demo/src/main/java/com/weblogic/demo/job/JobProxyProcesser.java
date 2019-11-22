package com.weblogic.demo.job;

import com.weblogic.demo.constant.JobConstant;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;
import us.codecraft.webmagic.selector.Html;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |     测试爬虫代理任务                     |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/11/22 14:23:39
 */
@Component
public class JobProxyProcesser implements PageProcessor {


    @Override
    public void process(Page page) {

        Html html = page.getHtml();
        System.out.println("您的IP地址：" + Jsoup.parse(html.css("div.contnull span").toString()).text());
    }

    @Override
    public Site getSite() {
        return Site.me()
                .setCharset("gbk")
                .setTimeOut(10 * 1000)
                .setRetrySleepTime(3000)
                .setRetryTimes(3);
    }

    public static void main(String[] args) {

        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        httpClientDownloader.setProxyProvider(
                SimpleProxyProvider.from(new Proxy("85.113.38.197", 8080),
                        new Proxy("106.14.144.179", 80),
                        new Proxy("177.87.10.186", 8080)));
        new Spider(new JobProxyProcesser())
                .addUrl("http://mip.chinaz.com/?query=")
                .setDownloader(httpClientDownloader)
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(10 * 10000)))
                .thread(5)
                .run();


    }
}
