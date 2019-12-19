package com.mall.search.controller;

import com.mall.search.dto.params.JobSearchParams;
import com.mall.search.repository.EsJobInfo;
import com.mall.search.service.JobSearchService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/12/13 14:57:40
 */
@RestController
@RequestMapping("/job")
@AllArgsConstructor
public class JobSearchController {


    private JobSearchService jobSearchService;


    @GetMapping("/page")
    public Page<EsJobInfo> getJobListByPage(JobSearchParams jobSearchParams){
        return jobSearchService.getJobListByPage(jobSearchParams);
    }

}
