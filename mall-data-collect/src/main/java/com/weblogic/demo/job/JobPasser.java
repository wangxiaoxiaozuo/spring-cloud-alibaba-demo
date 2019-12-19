package com.weblogic.demo.job;

import cn.hutool.core.collection.CollUtil;
import com.weblogic.demo.constant.JobConstant;
import com.weblogic.demo.dto.JobInfo;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * @program mall
 * @description:
 * @author: wangjian
 * @create: 2019/11/21 10:00:45
 */
@Component
public class JobPasser implements PageProcessor {

    @Override
    public void process(Page page) {

        List<Selectable> nodes = page.getHtml().css("div#resultList div.el").nodes();
        //列表页,解析出详情页的地址，放到任务列表中
        if (CollUtil.isNotEmpty(nodes)) {
            //加入到任务队列
            nodes.forEach(selectable ->
                    page.addTargetRequest(selectable.links().toString())
            );
            //获取下一页的页面
            String bkUrl = page.getHtml().css("div.p_in li.bk").nodes().get(1).links().toString();
            page.addTargetRequest(bkUrl);
            //详情页
        } else {
            this.saveJobInfo(page);
        }
    }

    private void saveJobInfo(Page page) {
        Html html = page.getHtml();
        JobInfo jobInfo = new JobInfo()
                .setCompanyName(html.css("div.cn p.cname a", "text").toString())
//                .setCompanyAddr(Jsoup.parse(html.css("div.bmsg p").nodes().get(1).toString()).text())
//                .setCompanyInfo(Jsoup.parse(html.css("div.tmsg p").toString()).text())
                .setJobName(html.css("div.cn h1", "text").toString())
//                .setJobAddr(html.css("div.cn span.lname","text").toString())
                .setJobInfo(Jsoup.parse(html.css("div.job_msg").toString()).text())
                .setUrl(page.getUrl().toString())
                .setSalary(html.css("div.cn strong","text").toString());
        //保存封装好的信息
        page.putField(JobConstant.JOB_KEY, jobInfo);
    }

    @Override
    public Site getSite() {
        return Site.me()
                .setCharset("gbk")
                .setTimeOut(10 * 1000)
                .setRetrySleepTime(3000)
                .setRetryTimes(3);
    }

}
