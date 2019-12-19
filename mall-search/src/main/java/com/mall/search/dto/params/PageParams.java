package com.mall.search.dto.params;

import lombok.Data;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |        分页参数封装                      |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/12/13 15:13:16
 */
@Data
public class PageParams {

    /**
     * 当前页
     */
    private Integer page;

    /**
     * 每页条数
     */
    private Integer size;

}
