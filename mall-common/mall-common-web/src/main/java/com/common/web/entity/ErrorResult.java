package com.common.web.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |       异常结果处理类                     |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/12/20 14:47:53
 */
@Data
@Accessors(chain = true)
public class ErrorResult {

    /**
     * 响应状态码
     */
    private HttpStatus httpStatus;

    /**
     * 错误信息
     */
    private String msg;

}
