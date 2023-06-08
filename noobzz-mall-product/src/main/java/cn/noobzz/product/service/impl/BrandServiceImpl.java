package cn.noobzz.product.service.impl;

import cn.noobzz.common.redis.service.RedisService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.noobzz.product.mapper.BrandMapper;
import cn.noobzz.mall.core.domain.Brand;
import cn.noobzz.product.service.IBrandService;

import javax.annotation.PostConstruct;
import java.util.List;

import cn.noobzz.common.redis.constants.RedisConstant;

/**
 * 商品品牌Service业务层处理
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:54
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private BrandMapper brandMapper;

    @PostConstruct
    public void init(){
        List<Brand> brands = brandMapper.selectList(new QueryWrapper<>());
        brands.forEach(each->{
            String format = String.format(RedisConstant.BRAND_FORMAT_STRING,each.getBrandId());
            redisService.setCacheObject(format,each);
        });

    }
}