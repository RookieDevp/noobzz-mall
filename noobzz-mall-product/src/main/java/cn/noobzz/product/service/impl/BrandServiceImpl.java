package cn.noobzz.product.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.noobzz.product.mapper.BrandMapper;
import cn.noobzz.mall.core.domain.Brand;
import cn.noobzz.product.service.IBrandService;

/**
 * 商品品牌Service业务层处理
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:54
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

}