package com.mall.search.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/12/13 14:53:36
 */
public interface JobRepository extends ElasticsearchRepository<EsJobInfo, Integer> {


    /**
      * 功能描述: 分页查询条件 job
      * @author : wangjian
      * @since : 2019-12-13 15:23
      */
    Page<EsJobInfo> findAllByJobInfo(Pageable pageable,String content);

}
