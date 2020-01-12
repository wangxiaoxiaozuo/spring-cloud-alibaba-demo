package com.mall.admin.security.handler;

import com.mall.admin.security.SysUserDetail;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |   Security 登录成功处理器                |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2020/01/09 09:46:53
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        SysUserDetail userInfo = (SysUserDetail) authentication.getPrincipal();
        AjaxResponseHandler.handle(response, HttpStatus.OK, userInfo.getSysUser().getUserId());
    }
}
