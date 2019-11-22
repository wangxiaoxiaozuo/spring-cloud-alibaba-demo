package com.weblogic.demo.handler;

import com.weblogic.demo.constant.JobConstant;
import com.weblogic.demo.dto.JobInfo;
import com.weblogic.demo.service.JobPasserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @program mall
 * @description: mysql 结果集处理器
 * @author: wangjian
 * @create: 2019/11/22 10:16:01
 */
@Component
public class JobResultMySqlHandler implements Pipeline {

    @Autowired
    private JobPasserService jobPasserService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        JobInfo jobInfo = resultItems.get(JobConstant.JOB_KEY);
        if (jobInfo != null) {
            jobPasserService.saveJobInfo(jobInfo);
        }
    }
}
