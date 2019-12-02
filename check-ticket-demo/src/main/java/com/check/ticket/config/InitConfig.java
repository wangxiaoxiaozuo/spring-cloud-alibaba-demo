package com.check.ticket.config;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |           假数据初始化                   |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/11/29 11:14:59
 */
@Configuration
@Slf4j
public class InitConfig {

    public static Set<String> ticketList = Collections.synchronizedSet(new HashSet<>());

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private Executor taskExecutor;


//    @PostConstruct
//    public void initData() {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start("redis set");
//        CountDownLatch countDownLatch = new CountDownLatch(10);
//        for (int i = 0; i < 10; i++) {
//            taskExecutor.execute(() -> {
//                for (int j = 0; j < 10000; j++) {
//                    String ticketNo = createTicketNo();
//                    System.out.println(ticketNo);
//                    ticketList.add(ticketNo);
//                }
//                log.info("{}:生产完票", Thread.currentThread().getName());
//                countDownLatch.countDown();
//            });
//        }
//        try {
//            countDownLatch.await();
//            stopWatch.stop();
//            System.out.println(stopWatch.prettyPrint());
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public String createTicketNo() {
//        String formatDate = DateUtil.format(new Date(), "yyyyMMdd");
//        // key存在返回加一后数据，不存在返回1
//        Long num = redisTemplate.opsForValue().increment("TICKET", 1L);
//        if (num.compareTo(1L) == 0) {
//            //当序列号等于1时，设置key过期时间
//            redisTemplate.expire("TICKET", 48, TimeUnit.HOURS);
//        }
//        return formatDate + String.format("%06d", num);
//    }



}
