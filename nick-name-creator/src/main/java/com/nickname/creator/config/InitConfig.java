package com.nickname.creator.config;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.nickname.creator.constant.ExcelConstant;
import com.nickname.creator.dto.NickNameRuleExcelDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/11/26 13:52:07
 */
@Configuration
public class InitConfig {

    public static List<String> nickNamePrefix = new ArrayList<>();

    public static List<String> nickNameSuffix = new ArrayList<>();

    @PostConstruct
    public void init() {
        List<NickNameRuleExcelDto> list = ExcelImportUtil.importExcel(
                new File(ExcelConstant.NEW_EXCEL_PATH),
                NickNameRuleExcelDto.class, new ImportParams());
        if (!CollectionUtils.isEmpty(list)) {
            //获取去重后数据
            nickNamePrefix = list.stream()
                    .map(NickNameRuleExcelDto::getNickNamePrefix)
                    .distinct()
                    .collect(Collectors.toList());
            nickNameSuffix = list.stream()
                    .map(NickNameRuleExcelDto::getNickNameSuffix)
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println(nickNamePrefix.size());
            System.out.println(nickNameSuffix.size());
        }
    }


}
