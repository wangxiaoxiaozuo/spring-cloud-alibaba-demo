package com.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.common.web.utils.VerifyException;
import com.mall.admin.entity.SysRoleResource;
import com.mall.admin.mapper.SysRoleResourceMapper;
import com.mall.admin.service.ISysRoleResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * @since 2020-01-02
 */
@Service
public class SysRoleResourceServiceImpl extends ServiceImpl<SysRoleResourceMapper, SysRoleResource> implements ISysRoleResourceService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void grantMenuToRoleId(Integer roleId, List<Integer> menuIds) {
        //先删除 然后重新授权
        VerifyException.CollectIsNull(menuIds, "未选择权限");
        LambdaQueryWrapper<SysRoleResource> eq =
                Wrappers.<SysRoleResource>lambdaQuery()
                        .eq(SysRoleResource::getRoleId, roleId);
        this.baseMapper.delete(eq);
        List<SysRoleResource> list = new ArrayList<>();
        menuIds.forEach(s ->
            list.add(new SysRoleResource()
                    .setRoleId(roleId)
                    .setResourceId(s))
        );
        this.saveBatch(list);
    }
}
