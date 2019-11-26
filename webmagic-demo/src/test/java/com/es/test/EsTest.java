package com.es.test;

import com.weblogic.demo.WebMagicApplication;
import com.weblogic.demo.dto.EsJobInfo;
import com.weblogic.demo.repository.es.EsJobRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/11/25 10:09:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebMagicApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EsTest {

    @Resource
    private EsJobRepository esJobRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @Test
    public void test() {
        EsJobInfo esJobInfo = new EsJobInfo()
                .setId(1)
                .setCompanyInfo("北京易邻里科技有限公司")
                .setCompanyAddr("融科望京中心")
                .setCompanyName("北京易邻里科技有限公司")
                .setJobInfo("teest")
                .setJobName("Java")
                .setSalary("19")
                .setJobAddr("~~~~");
        esJobRepository.save(esJobInfo);

    }


    @Test
    public void deleteIndex() {
        elasticsearchTemplate.deleteIndex(EsJobInfo.class);
    }

    @Test
    public void createIndex() {
        elasticsearchTemplate.createIndex(EsJobInfo.class);
        elasticsearchTemplate.putMapping(EsJobInfo.class);
    }

}
