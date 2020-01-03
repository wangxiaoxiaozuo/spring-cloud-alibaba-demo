package com.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.web.utils.VerifyException;
import com.mall.admin.entity.SysUser;
import com.mall.admin.entity.SysUserRole;
import com.mall.admin.mapper.SysUserMapper;
import com.mall.admin.mapper.SysUserRoleMapper;
import com.mall.admin.service.ISysUserRoleService;
import com.mall.admin.service.ISysUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangjian
 * @since 2019-12-25
 */
@Service
@AllArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {


    private ISysUserRoleService sysUserRoleService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addSysUser(SysUser sysUser) {
        //1.添加用户
        this.baseMapper.insert(sysUser);
        //2.添加用户权限关联表
        List<Integer> roleIds = sysUser.getRoleIds();
        VerifyException.CollectIsNull(roleIds, "未选择角色");
        List<SysUserRole> list = new ArrayList<>();
        roleIds.forEach(s ->
                list.add(new SysUserRole()
                        .setUserId(sysUser.getUserId())
                        .setRoleId(s))
        );
        sysUserRoleService.saveBatch(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysUser(SysUser sysUser) {
        this.baseMapper.updateById(sysUser);

        List<Integer> roleIds = sysUser.getRoleIds();
        VerifyException.CollectIsNull(roleIds, "未选择权限");

        LambdaQueryWrapper<SysUserRole> eq =
                Wrappers.<SysUserRole>lambdaQuery()
                        .eq(SysUserRole::getUserId, sysUser.getUserId());
        sysUserRoleService.remove(eq);

        List<SysUserRole> list = new ArrayList<>();
        roleIds.forEach(s ->
                list.add(new SysUserRole()
                        .setUserId(sysUser.getUserId())
                        .setRoleId(s))
        );
        sysUserRoleService.saveBatch(list);


    }
}
