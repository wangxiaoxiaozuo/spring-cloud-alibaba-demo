package com.nickname.creator.service;


import java.util.List;

public interface NickNameService {
    List<String> getNickNameList(Integer size);

    Integer getUnlessNickNameCount();

    void updateNickNameByGroup();
}
