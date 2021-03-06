package com.weblogic.demo.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.weblogic.demo.dto.JobInfo;
import com.weblogic.demo.repository.mysql.JobInfoRepository;
import com.weblogic.demo.service.JobPasserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @program mall
 * @description:
 * @author: wangjian
 * @create: 2019/11/21 15:48:06
 */
@Service
public class JobPasserServiceImpl implements JobPasserService {


    @Autowired
    private JobInfoRepository jobInfoRepository;

    @Autowired
    private Spider spider;

    @Resource
    private Executor executor;


    @Override
    public void saveJobInfo(JobInfo jobInfo) {
        //查询是否存在
        JobInfo param = new JobInfo()
                .setUrl(jobInfo.getUrl())
                .setTime(jobInfo.getTime());
        List<JobInfo> list = this.getList(param);
        //不存在保存
        if (CollUtil.isEmpty(list)) {
            jobInfoRepository.saveAndFlush(jobInfo);
        }
    }

    @Override
    public List<JobInfo> getList(JobInfo jobInfo) {
        Example<JobInfo> example = Example.of(jobInfo);
        return jobInfoRepository.findAll(example);
    }

    @Override
    public void startJob() {
        executor.execute(() -> spider.run());
    }

    @Override
    public void stopJob() {
        executor.execute(() -> spider.stop());
    }
}
