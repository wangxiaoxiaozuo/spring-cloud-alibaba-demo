package com.weblogic.demo.service;

import com.weblogic.demo.dto.JobInfo;

import java.util.List;

public interface JobPasserService {

    void saveJobInfo(JobInfo jobInfo);

    List<JobInfo> getList(JobInfo jobInfo);

    /**
      * 功能描述: 启动爬虫任务
      * @author : wangjian
      * @since  : 2019-11-22 17:26
      */
    void startJob();

    /**
      * 功能描述:
      *
      * @author : wangjian
      * @since : 2019-11-22 17:29
      */
    void stopJob();
}
