package cn.noobzz.product.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.noobzz.product.mapper.StockMapper;
import cn.noobzz.mall.core.domain.Stock;
import cn.noobzz.product.service.IStockService;

/**
 * 商品库存Service业务层处理
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:55
 */
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements IStockService {

}