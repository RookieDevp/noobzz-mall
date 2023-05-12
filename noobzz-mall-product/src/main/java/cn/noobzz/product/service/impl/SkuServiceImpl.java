package cn.noobzz.product.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.noobzz.product.mapper.SkuMapper;
import cn.noobzz.mall.core.domain.Sku;
import cn.noobzz.product.service.ISkuService;

/**
 * 商品SKUService业务层处理
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:55
 */
@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements ISkuService {

}