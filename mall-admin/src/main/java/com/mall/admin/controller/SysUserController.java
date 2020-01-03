package com.mall.admin.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.admin.entity.SysUser;
import com.mall.admin.entity.SysUserRole;
import com.mall.admin.entity.param.SysUserDTO;
import com.mall.admin.service.ISysUserRoleService;
import com.mall.admin.service.ISysUserService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

/**
 * 查询商铺后台管理用户
 */
@RestController
@RequestMapping("/sysUser")
@AllArgsConstructor
public class SysUserController {

    private ISysUserService sysUserService;

    private ISysUserRoleService sysUserRoleService;

    @GetMapping("/page")
    public IPage<SysUser> getSysUserByPage(@Validated SysUserDTO sysUserDTO) {
        LambdaQueryWrapper<SysUser> eq =
                Wrappers.<SysUser>lambdaQuery()
                        .like(StrUtil.isNotBlank(sysUserDTO.getCondition()), SysUser::getUserName, sysUserDTO.getCondition())
                        .eq(SysUser::getDeleted, 0)
                        .orderByDesc(SysUser::getCreateTime);
        Page<SysUser> sysUserPage = new Page<>(sysUserDTO.getPage(), sysUserDTO.getSize());
        IPage<SysUser> page = sysUserService.page(sysUserPage, eq);
        page.getRecords().forEach(s -> {
            LambdaQueryWrapper<SysUserRole> eq1 = Wrappers.<SysUserRole>lambdaQuery()
                    .eq(SysUserRole::getUserId, s.getUserId());
            s.setRoleIds(sysUserRoleService.list(eq1).stream().map(SysUserRole::getRoleId).collect(Collectors.toList()));
        });
        return page;
    }

    @PostMapping
    public void addUser(@Validated @RequestBody SysUser sysUser) {
        sysUserService.addSysUser(sysUser);
    }

    @PutMapping("/{userId}/{userState}")
    public void updateUserState(@PathVariable Integer userId, @PathVariable String userState) {
        LambdaUpdateWrapper<SysUser> eq =
                Wrappers.<SysUser>lambdaUpdate()
                        .set(SysUser::getLocked, userState)
                        .eq(SysUser::getUserId, userId);
        sysUserService.update(eq);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Integer userId) {
        sysUserService.removeById(userId);
    }

    @PutMapping("/{userId}")
    public void updateUserById(@PathVariable Integer userId, @Validated @RequestBody SysUser sysUser) {
        sysUser.setUserId(userId);
        sysUserService.updateSysUser(sysUser);
    }


}
