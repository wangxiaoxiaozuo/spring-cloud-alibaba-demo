package com.mall.search.service;

import com.mall.search.dto.params.JobSearchParams;
import com.mall.search.repository.EsJobInfo;
import org.springframework.data.domain.Page;

public interface JobSearchService {


    Page<EsJobInfo> getJobListByPage(JobSearchParams jobSearchParams);
}
