package com.mall.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |        搜索服务--集成 ElasticSearch     |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/12/13 14:36:24
 */
@SpringBootApplication
public class SearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
    }
}
