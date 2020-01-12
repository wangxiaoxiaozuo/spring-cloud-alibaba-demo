package com.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.admin.entity.SysRole;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangjian
 * @since 2019-12-26
 */
public interface ISysRoleService extends IService<SysRole> {

    void deleteRoleById(Integer roleId);

    void addRole(SysRole sysRole);
}
