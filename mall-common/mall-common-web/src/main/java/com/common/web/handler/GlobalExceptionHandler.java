package com.common.web.handler;

import com.common.web.entity.ErrorResult;
import com.common.web.exception.MallException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |    全局异常处理                          |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/12/20 14:13:29
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = MallException.class)
    public ErrorResult handlerSelfException(MallException e){
        return new ErrorResult()
                .setHttpStatus(HttpStatus.BAD_REQUEST)
                .setMsg(e.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ErrorResult handlerNormalException(RuntimeException e){
        return new ErrorResult()
                .setHttpStatus(HttpStatus.BAD_REQUEST)
                .setMsg(e.getMessage());
    }



}
