package com.mall.search.dto.params;

import lombok.Data;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/12/13 15:12:31
 */
@Data
public class JobSearchParams extends PageParams{

    /**
     * 查询内容
     */
    private String content;

}
