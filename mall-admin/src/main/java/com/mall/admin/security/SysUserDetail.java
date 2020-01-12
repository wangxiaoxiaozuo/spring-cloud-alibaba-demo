package com.mall.admin.security;

import cn.hutool.core.collection.CollUtil;
import com.mall.admin.entity.SysRole;
import com.mall.admin.entity.SysUser;
import com.mall.admin.enums.SysUserStateEnum;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |        Security 统一用户返回体           |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2020/01/06 17:28:22
 */
@Getter
public class SysUserDetail implements UserDetails {

    private SysUser sysUser;

    private List<SysRole> roleList;

    public SysUserDetail(SysUser sysUser, List<SysRole> roleList) {
        this.sysUser = sysUser;
        this.roleList = roleList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (CollUtil.isNotEmpty(roleList)) {
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            roleList.forEach(s ->
                authorities.add(new SimpleGrantedAuthority(s.getRoleCode()))
            );
            return authorities;
        }
        return null;
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return SysUserStateEnum.NORMAL.getUserState().equals(sysUser.getLocked());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
