package com.nickname.creator.dto;

import lombok.Data;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/11/26 10:50:50
 */
@Data
public class NickNameRuleExcelDto {

    /**
      * nickName前缀
      */
    private String nickNamePrefix;

    /**
     *
     */
    private String nickNameSuffix;


}
