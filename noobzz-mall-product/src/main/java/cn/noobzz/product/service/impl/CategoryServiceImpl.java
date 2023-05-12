package cn.noobzz.product.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.noobzz.product.mapper.CategoryMapper;
import cn.noobzz.mall.core.domain.Category;
import cn.noobzz.product.service.ICategoryService;

/**
 * 商品分类Service业务层处理
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:54
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}