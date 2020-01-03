package com.mall.admin.mapper;

import com.mall.admin.entity.MallCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 商品类目表，类目和商品(spu)是一对多关系，类目与品牌是多对多关系 Mapper 接口
 * </p>
 *
 * @author wangjian
 * @since 2020-01-02
 */
public interface MallCategoryMapper extends BaseMapper<MallCategory> {

}
