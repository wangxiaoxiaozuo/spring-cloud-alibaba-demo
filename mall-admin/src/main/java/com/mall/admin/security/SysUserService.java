package com.mall.admin.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.common.web.utils.VerifyException;
import com.mall.admin.entity.SysRole;
import com.mall.admin.entity.SysUser;
import com.mall.admin.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |      Security 验证用户是否正确           |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2020/01/06 17:28:49
 */
@Component
@Slf4j
public class SysUserService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUserDetail sysUserDetail = getUserByUserName(userName);
        return sysUserDetail;
    }

    /**
     * 获取用户
     */
    public SysUserDetail getUserByUserName(String userName) {
        LambdaQueryWrapper<SysUser> eq =
            Wrappers.<SysUser>lambdaQuery()
                .eq(SysUser::getUserName, userName);
        //TODO 查询合并 一对多
        SysUser sysUser = sysUserMapper.selectOne(eq);
        VerifyException.isNull(sysUser, "用户名或用户密码不正确");
        List<SysRole> roleList = sysUserMapper.getRoleList(sysUser.getUserId());
        return new SysUserDetail(sysUser, roleList);
    }
}
