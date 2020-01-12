package com.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.admin.entity.SysRoleResource;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangjian
 * @since 2020-01-02
 */
public interface ISysRoleResourceService extends IService<SysRoleResource> {

    void grantMenuToRoleId(Integer roleId, List<Integer> menuIds);
}
