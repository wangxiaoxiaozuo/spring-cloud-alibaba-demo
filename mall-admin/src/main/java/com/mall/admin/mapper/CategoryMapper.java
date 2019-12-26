package com.mall.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.admin.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品类目表，类目和商品(spu)是一对多关系，类目与品牌是多对多关系 Mapper 接口
 * </p>
 *
 * @author wangjian
 * @since 2019-12-19
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
