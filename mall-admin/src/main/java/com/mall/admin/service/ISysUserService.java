package com.mall.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.admin.entity.SysUser;
import com.mall.admin.entity.param.SysUserDTO;
import com.mall.admin.entity.vo.SysUserVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangjian
 * @since 2019-12-25
 */
public interface ISysUserService extends IService<SysUser> {

    void grantUserRole(Integer userId, List<Integer> roleIds);

    IPage<SysUserVo> getSySUserVoByPage(SysUserDTO sysUserDTO);
}
