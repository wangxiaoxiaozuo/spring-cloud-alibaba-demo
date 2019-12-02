package com.nickname.test;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.nickname.creator.constant.ExcelConstant;
import com.nickname.creator.dto.NickNameRuleExcelDto;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/11/26 11:16:34
 */
public class Test {

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("red", 16.0);
        map.put("green", 15.7);
        map.put("yellow", 23.4);
        map.forEach((k, v) -> System.out.println(k + ":" + v));

    }
}
