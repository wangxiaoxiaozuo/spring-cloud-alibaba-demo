package com.nickname.creator.controller;

import com.nickname.creator.service.NickNameService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/11/26 13:57:16
 */
@RestController
@AllArgsConstructor
public class NickNameController {

    private NickNameService nickNameService;

    @GetMapping("/getList/{size}")
    public List<String> getNickNameList(@PathVariable("size") Integer size) {
        return nickNameService.getNickNameList(size);
    }

    @GetMapping("/getUnlessNickNameCount")
    public Integer getUnlessNickNameCount(){
        return nickNameService.getUnlessNickNameCount();
    }

    @GetMapping("/updateNickNameByGroup")
    public String updateNickNameByGroup(){
        nickNameService.updateNickNameByGroup();
        return "NickName is updating ....";
    }
}
