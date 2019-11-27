package com.nickname.creator.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

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
@ToString
public class NickNameRuleExcelDto implements Serializable {

    /**
     * nickName前缀
     */
    @Excel(name = "昵称前缀")
    private String nickNamePrefix;

    /**
     * nickName后缀
     */
    @Excel(name = "昵称后缀")
    private String nickNameSuffix;


}
