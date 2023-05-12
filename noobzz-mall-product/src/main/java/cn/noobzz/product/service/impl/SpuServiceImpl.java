package cn.noobzz.product.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.noobzz.product.mapper.SpuMapper;
import cn.noobzz.mall.core.domain.Spu;
import cn.noobzz.product.service.ISpuService;

/**
 * 商品SPUService业务层处理
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:55
 */
@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, Spu> implements ISpuService {

}