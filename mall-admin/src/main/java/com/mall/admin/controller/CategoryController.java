package com.mall.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.common.web.exception.MallException;
import com.mall.admin.entity.Category;
import com.mall.admin.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <pre>
 * +--------+---------+-----------+---------+
 * |      商品分类                           |
 * +--------+---------+-----------+---------+
 * </pre>
 *
 * @author wangjian
 * @since 2019/12/20 08:50:28
 */
@RestController
@RequestMapping("/category")
@Api(tags = "商品分类")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{pid}")
    @ApiOperation(value = "查询商品种类菜单")
    public List<Category> getCategoryList(@PathVariable String pid) {
        LambdaQueryWrapper<Category> eq =
                new LambdaQueryWrapper<Category>()
                        .eq(Category::getParentId, pid)
                        .orderByAsc(Category::getSort);
        return categoryService.list(eq);
    }


}
