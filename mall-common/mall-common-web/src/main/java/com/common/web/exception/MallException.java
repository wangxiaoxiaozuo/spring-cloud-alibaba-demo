package com.common.web.exception;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |     商城统一异常类                       |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/12/20 14:15:19
 */
public class MallException extends RuntimeException{

    public MallException(String message) {
        super(message);
    }
}
