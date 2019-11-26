package com.weblogic.demo.handler;

import cn.hutool.core.bean.BeanUtil;
import com.weblogic.demo.constant.JobConstant;
import com.weblogic.demo.dto.EsJobInfo;
import com.weblogic.demo.dto.JobInfo;
import com.weblogic.demo.repository.es.EsJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |   ElasticSearch 结果处理器              |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/11/22 17:36:16
 */
@Component
public class JobResultElasticSearchHandler implements Pipeline {


    @Autowired
    private EsJobRepository esJobRepository;

    @Override
    public void process(ResultItems resultItems, Task task) {
        //保存数据到ES中
        JobInfo jobInfo = resultItems.get(JobConstant.JOB_KEY);
        EsJobInfo esJobInfo = new EsJobInfo();
        BeanUtil.copyProperties(jobInfo, esJobInfo);
        esJobRepository.save(esJobInfo);
    }
}
