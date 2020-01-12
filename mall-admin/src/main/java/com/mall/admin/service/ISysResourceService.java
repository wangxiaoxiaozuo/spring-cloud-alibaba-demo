package com.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.admin.entity.SysResource;
import com.mall.admin.entity.vo.MenuTreeVo;
import com.mall.admin.entity.vo.MenuVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wangjian
 * @since 2019-12-27
 */
public interface ISysResourceService extends IService<SysResource> {

    List<MenuTreeVo> getMenuTree();

    List<MenuVo> getMenuList();

    List<MenuVo> getOwnMenuByUserId(Integer userId);
}
