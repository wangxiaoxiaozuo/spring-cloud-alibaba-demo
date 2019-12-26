package com.mall.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.admin.entity.Category;
import com.mall.admin.mapper.CategoryMapper;
import com.mall.admin.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品类目表，类目和商品(spu)是一对多关系，类目与品牌是多对多关系 服务实现类
 * </p>
 *
 * @author wangjian
 * @since 2019-12-19
 */
@Service
public class TbCategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
