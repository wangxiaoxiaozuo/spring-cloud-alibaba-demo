package com.weblogic.demo.service;

import com.weblogic.demo.dto.JobInfo;

import java.util.List;

public interface JobPasserService {

    void saveJobInfo(JobInfo jobInfo);

    List<JobInfo> getList(JobInfo jobInfo);
}
