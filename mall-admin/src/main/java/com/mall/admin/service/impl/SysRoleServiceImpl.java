package com.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.admin.entity.SysRole;
import com.mall.admin.entity.SysRoleResource;
import com.mall.admin.mapper.SysRoleMapper;
import com.mall.admin.service.ISysRoleResourceService;
import com.mall.admin.service.ISysRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangjian
 * @since 2019-12-26
 */
@Service
@AllArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    private ISysRoleResourceService sysRoleResourceService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRoleById(Integer roleId) {
        this.baseMapper.deleteById(roleId);
        //删除权限下授权的菜单
        LambdaQueryWrapper<SysRoleResource> eq =
                Wrappers.<SysRoleResource>lambdaQuery()
                        .eq(SysRoleResource::getRoleId, roleId);
        sysRoleResourceService.remove(eq);
    }
}
