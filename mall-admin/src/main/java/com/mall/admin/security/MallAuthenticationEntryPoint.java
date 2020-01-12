package com.mall.admin.security;

import com.mall.admin.security.handler.AjaxResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |   自定义前后端分离返回JSON数据             |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2020/01/09 09:46:53
 */
public class MallAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        AjaxResponseHandler.handle(response, HttpStatus.UNAUTHORIZED, authException.getMessage());
    }
}
