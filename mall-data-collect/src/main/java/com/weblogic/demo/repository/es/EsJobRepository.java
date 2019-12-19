package com.weblogic.demo.repository.es;

import com.weblogic.demo.dto.EsJobInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |  操作ElasticSearch Ddo                  |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/11/25 09:00:28
 */
public interface EsJobRepository extends ElasticsearchRepository<EsJobInfo, Integer> {


}
