package com.mall.search.service.impl;

import com.mall.search.dto.params.JobSearchParams;
import com.mall.search.repository.EsJobInfo;
import com.mall.search.repository.JobRepository;
import com.mall.search.service.JobSearchService;
import com.oracle.javafx.jmx.json.impl.JSONMessages;
import lombok.AllArgsConstructor;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/12/13 15:10:31
 */
@Service
@AllArgsConstructor
public class JobSearchServiceImpl implements JobSearchService {

    private JobRepository jobRepository;

    @Override
    public Page<EsJobInfo> getJobListByPage(JobSearchParams jobSearchParams) {
        return jobRepository.findAllByJobInfo(
                PageRequest.of(jobSearchParams.getPage(),
                        jobSearchParams.getSize()), jobSearchParams.getContent());
    }
}
