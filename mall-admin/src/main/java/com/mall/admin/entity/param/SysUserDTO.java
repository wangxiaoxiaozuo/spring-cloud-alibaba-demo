package com.mall.admin.entity.param;

import com.mall.admin.entity.common.PageParams;
import lombok.Data;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/12/25 18:00:40
 */
@Data
public class SysUserDTO extends PageParams {

    private String condition;


}
