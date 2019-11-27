package com.nickname.creator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NickNameMapper extends BaseMapper {

    List<Long> getUnlessNickNameUserId(Integer page);

    Integer getUnlessNickNameCount();

    void updateNickNameByUserId(@Param("nickName") String nickName, @Param("userId") Long userId);
}