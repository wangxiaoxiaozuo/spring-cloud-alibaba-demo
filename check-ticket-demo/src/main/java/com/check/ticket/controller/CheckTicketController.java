package com.check.ticket.controller;

import com.check.ticket.service.CheckTicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/11/29 11:04:02
 */
@RestController
@AllArgsConstructor
@Api(tags = "购票测试")
public class CheckTicketController {

    private CheckTicketService checkTicketService;

    @GetMapping("/check/qrCode/{code}")
    @ApiOperation("购票测试服务")
    public String checkQrCodeTicket(@PathVariable("code") String code) {
        return checkTicketService.checkQrCodeTicket(code);
    }

}
