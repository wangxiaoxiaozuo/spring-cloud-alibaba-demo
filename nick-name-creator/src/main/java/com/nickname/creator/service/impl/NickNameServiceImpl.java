package com.nickname.creator.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import com.nickname.creator.config.InitConfig;
import com.nickname.creator.dto.OwnerUserDto;
import com.nickname.creator.mapper.NickNameMapper;
import com.nickname.creator.service.NickNameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/11/26 13:59:56
 */
@Service
@AllArgsConstructor
public class NickNameServiceImpl implements NickNameService {


    private NickNameMapper nickNameMapper;

    private Executor taskExecutor;

    private static Set<String> nickNameListUsed = new HashSet<>();

    @Override
    public List<String> getNickNameList(Integer size) {
        List<String> nickNameList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            //获取nickName前缀下标
            int prefixIndex = new Random().nextInt(InitConfig.nickNamePrefix.size());
            //获取nickName后缀下标
            int suffixIndex = new Random().nextInt(InitConfig.nickNameSuffix.size());
            //生成nickName
            String nickName = createNickName(prefixIndex, suffixIndex);
            nickNameList.add(nickName);
        }
        return nickNameList;
    }

    @Override
    public Integer getUnlessNickNameCount() {
        return nickNameMapper.getUnlessNickNameCount();
    }

    private String createNickName(int prefixIndex, int suffixIndex) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(InitConfig.nickNamePrefix.get(prefixIndex))
                .append("的")
                .append(InitConfig.nickNameSuffix.get(suffixIndex)).toString();
    }


    private String getNickName() {
        String nickName;
        do {
            //获取nickName前缀下标
            int prefixIndex = new Random().nextInt(InitConfig.nickNamePrefix.size());
            //获取nickName后缀下标
            int suffixIndex = new Random().nextInt(InitConfig.nickNameSuffix.size());
            //生成nickName
            nickName = createNickName(prefixIndex, suffixIndex);
        } while (nickNameListUsed.contains(nickName));

        nickNameListUsed.add(nickName);
        return nickName;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateNickNameByGroup() {
        // 获取没有nickName的用户数量
        Integer unlessNickNameCount = nickNameMapper.getUnlessNickNameCount();
        if (unlessNickNameCount <= 0) {
            return;
        }
        // 50个用户为一组 分组
        int group = Convert.toInt(Math.ceil(new Double(unlessNickNameCount) / 50d));
        // countDownLatch 进行控制
        CountDownLatch countDownLatch = new CountDownLatch(group);
        for (int i = 1; i < group + 1; i++) {

            List<Long> unlessNickNameUserId = nickNameMapper.getUnlessNickNameUserId((i - 1) * 50);

            taskExecutor.execute(() -> {

                List<OwnerUserDto> list = new ArrayList<>();
                unlessNickNameUserId.forEach(userId ->
                        list.add(new OwnerUserDto(userId, getNickName()))
                );
                if (CollectionUtil.isNotEmpty(list)) {
                    nickNameMapper.updateNickNameByBatch(list);
                }
                countDownLatch.countDown();
            });

        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("更新完毕");

    }


}
