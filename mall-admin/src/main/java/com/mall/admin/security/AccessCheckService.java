package com.mall.admin.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |                                        |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2020/01/09 17:11:40
 */
@Component
public class AccessCheckService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();


    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        // 获取该用户的所绑定的权限
        List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication.getAuthorities();
        // 获取权限名称对应的请求路径
        List<String> roleNameList = grantedAuthorityList.stream()
            .map(SimpleGrantedAuthority::getAuthority)
            .collect(Collectors.toList());


        return false;
    }
}
