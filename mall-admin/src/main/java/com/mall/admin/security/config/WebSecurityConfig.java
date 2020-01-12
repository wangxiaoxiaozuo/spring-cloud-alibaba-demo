package com.mall.admin.security.config;

import com.mall.admin.security.MallAuthenticationEntryPoint;
import com.mall.admin.security.handler.DeniceHandler;
import com.mall.admin.security.handler.LoginFailHandler;
import com.mall.admin.security.handler.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |     spring-security 配置                |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2020/01/06 17:22:09
 */
@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/login","/sysResource/routerList").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginProcessingUrl("/login")
            .usernameParameter("username")
            .successHandler(new LoginSuccessHandler())
            .failureHandler(new LoginFailHandler())
            .and()
            .exceptionHandling().authenticationEntryPoint(new MallAuthenticationEntryPoint())
            .accessDeniedHandler(new DeniceHandler())
            .and()
            .csrf().disable();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
