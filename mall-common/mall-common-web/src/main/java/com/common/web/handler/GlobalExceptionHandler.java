package com.common.web.handler;

import com.common.web.entity.ErrorResult;
import com.common.web.exception.MallException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Objects;

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
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handlerSelfException(MallException e){
        return new ErrorResult()
                .setHttpStatus(HttpStatus.BAD_REQUEST)
                .setMsg(e.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handlerNormalException(RuntimeException e){
        return new ErrorResult()
                .setHttpStatus(HttpStatus.BAD_REQUEST)
                .setMsg(e.getMessage());
    }

    @ExceptionHandler({ConstraintViolationException.class, MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handlerNormalException(Exception e){
        String message = "参数校验【未知错误】";
        if (e.getClass().isAssignableFrom(ConstraintViolationException.class)) {
            message = ((ConstraintViolationException) e).getConstraintViolations().iterator().next()
                    .getMessage();
        } else if (e.getClass().isAssignableFrom(MethodArgumentNotValidException.class)) {
            message = Objects.requireNonNull(
                    ((MethodArgumentNotValidException) e).getBindingResult().getFieldError())
                    .getDefaultMessage();
        }
        return new ErrorResult()
                .setHttpStatus(HttpStatus.BAD_REQUEST)
                .setMsg(message);
    }



}
