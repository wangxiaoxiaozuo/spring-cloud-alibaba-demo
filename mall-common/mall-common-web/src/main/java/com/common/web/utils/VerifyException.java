package com.common.web.utils;

import com.common.web.exception.MallException;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |   验证工具类                            |
 * +--------+---------+-----------+---------+
 *
 * 1. 验证是否为空
 * </pre>
 *
 * @author wangjian
 * @since 2020/01/02 10:38:01
 */
public class VerifyException {

    /**
     * 空验证
     */
    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new MallException(message);
        }
    }

    /**
     * 集合验证
     */
    public static void CollectIsNull(Collection collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new MallException(message);
        }
    }

    public static void CollectIsNotNull(Collection collection, String message) {
        if (!CollectionUtils.isEmpty(collection)) {
            throw new MallException(message);
        }
    }
}
