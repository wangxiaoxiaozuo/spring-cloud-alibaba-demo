package com.mall.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.admin.entity.SysResource;
import com.mall.admin.entity.common.PageParams;
import com.mall.admin.entity.vo.MenuTreeVo;
import com.mall.admin.entity.vo.MenuVo;
import com.mall.admin.enums.MenuTypeEnum;
import com.mall.admin.service.ISysResourceService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单管理
 *
 * @author wangjian
 * @since 2019-12-27
 */
@RestController
@RequestMapping("/sysResource")
@AllArgsConstructor
public class SysResourceController {

    private ISysResourceService sysResourceService;

    @GetMapping("/page")
    public IPage<SysResource> getResourcePage(PageParams pageParams) {
        Page<SysResource> sysResourcePage = new Page<>(pageParams.getPage(), pageParams.getSize());
        return sysResourceService.page(sysResourcePage);
    }

    @GetMapping("/root")
    public List<SysResource> getRootMenu() {
        LambdaQueryWrapper<SysResource> wrapper =
                Wrappers.<SysResource>lambdaQuery()
                        .eq(SysResource::getType, MenuTypeEnum.CATALOG.getTypeCode())
                        .orderByAsc(SysResource::getSort);
        return sysResourceService.list(wrapper);
    }

    @PostMapping
    public void addSysResource(@Validated @RequestBody SysResource sysResource) {
        sysResourceService.save(sysResource);
    }

    @PutMapping("/{menuId}")
    public void updateSysResource(@Validated @RequestBody SysResource sysResource, @PathVariable Integer menuId) {
        sysResource.setMenuId(menuId);
        sysResourceService.updateById(sysResource);
    }

    @DeleteMapping("/{menuId}")
    public void deleteSysResource(@PathVariable Integer menuId) {
        sysResourceService.removeById(menuId);
    }

    @GetMapping("/menu")
    public List<MenuTreeVo> getMenuTree(){
        return sysResourceService.getMenuTree();
    }


    @GetMapping("/menuList")
    public List<MenuVo> getMenuList(){
        return sysResourceService.getMenuList();
    }




}
