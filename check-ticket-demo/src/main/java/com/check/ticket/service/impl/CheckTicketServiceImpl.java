package com.check.ticket.service.impl;

import com.check.ticket.config.InitConfig;
import com.check.ticket.service.CheckTicketService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/11/29 11:05:03
 */
@Service
@Slf4j
public class CheckTicketServiceImpl implements CheckTicketService {

    @Resource
    private Executor taskExecutor;

    private volatile Boolean checkResult;

    @Override
    public String checkQrCodeTicket(String code) {
        long startTime = System.currentTimeMillis();
//        for (int i = 0; i < 50; i++) {
//            taskExecutor.execute(() -> {
//                do {
//                    //数据分组
//
//                    if (InitConfig.ticketList.contains(code)) {
//                        log.info("{}:比对成功", Thread.currentThread().getName());
//                        checkResult = true;
//                        //终端所有线程？？？
//                        Thread.interrupted();
//                    }
//                    log.error("{}:比对结束", Thread.currentThread().getName());
//                } while (!checkResult);
//            });
//        }
        long endTime = System.currentTimeMillis();
        return "比对时间：" + (endTime - startTime) + "毫秒";
    }
}
