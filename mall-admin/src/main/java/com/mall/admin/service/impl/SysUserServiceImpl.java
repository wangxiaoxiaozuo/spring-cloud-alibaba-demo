package com.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.web.utils.VerifyException;
import com.mall.admin.entity.SysUser;
import com.mall.admin.entity.SysUserRole;
import com.mall.admin.entity.param.SysUserDTO;
import com.mall.admin.entity.vo.SysUserVo;
import com.mall.admin.mapper.SysUserMapper;
import com.mall.admin.service.ISysUserRoleService;
import com.mall.admin.service.ISysUserService;
import lombok.AllArgsConstructor;
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
    public void grantUserRole(Integer userId, List<Integer> roleIds) {
        VerifyException.CollectIsNull(roleIds, "权限为空，无法授权");
        // 1.清空原本的权限
        LambdaQueryWrapper<SysUserRole> wrapper =
            Wrappers.<SysUserRole>lambdaQuery()
                .eq(SysUserRole::getUserId, userId);
        sysUserRoleService.remove(wrapper);
        // 2.授权
        List<SysUserRole> list = new ArrayList<>();
        roleIds.forEach(s ->
            list.add(new SysUserRole().setUserId(userId).setRoleId(s))
        );
        sysUserRoleService.saveBatch(list);
    }


    @Override
    public IPage<SysUserVo> getSySUserVoByPage(SysUserDTO sysUserDTO) {
        Page<SysUserVo> sysUserPage = new Page<>(sysUserDTO.getPage(), sysUserDTO.getSize());
        return this.baseMapper.getUserAndRoleList(sysUserPage, sysUserDTO.getCondition());
    }
}
