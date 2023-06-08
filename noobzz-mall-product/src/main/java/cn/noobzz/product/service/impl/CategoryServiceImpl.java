package cn.noobzz.product.service.impl;

import cn.noobzz.common.redis.constants.RedisConstant;
import cn.noobzz.common.redis.service.RedisService;
import cn.noobzz.mall.core.domain.Brand;
import cn.noobzz.product.mapper.BrandMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.noobzz.product.mapper.CategoryMapper;
import cn.noobzz.mall.core.domain.Category;
import cn.noobzz.product.service.ICategoryService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 商品分类Service业务层处理
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:54
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private CategoryMapper categoryMapper;

    @PostConstruct
    public void init(){
        List<Category> categorys = categoryMapper.selectList(new QueryWrapper<>());
        categorys.forEach(each->{
            String format = String.format(RedisConstant.CATEGORY_FORMAT_STRING,each.getCategoryId());
            redisService.setCacheObject(format,each);
        });

    }
}