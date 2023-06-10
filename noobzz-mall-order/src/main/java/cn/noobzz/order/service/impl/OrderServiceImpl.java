package cn.noobzz.order.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.noobzz.common.redis.constants.RedisConstant;
import cn.noobzz.common.redis.service.RedisService;
import cn.noobzz.mall.core.constants.OrderConstant;
import cn.noobzz.mall.core.domain.Sku;
import cn.noobzz.mall.core.domain.Stock;
import cn.noobzz.mall.core.feign.SkuFeignService;
import cn.noobzz.mall.core.feign.StockeignService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.noobzz.order.mapper.OrderMapper;
import cn.noobzz.mall.core.domain.Order;
import cn.noobzz.order.service.IOrderService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 订单信息Service业务层处理
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:54
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private SkuFeignService skuFeignService;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StockeignService stockeignService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveOrder(Order order) {

        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        Snowflake snowflake = IdUtil.getSnowflake();
        String orderSn = snowflake.nextId()+"";
        order.setOrderSn(orderSn);
        order.setUserId(Long.parseLong(tokenInfo.loginId+""));
        order.setOrderStatus(OrderConstant.ORDER_STATUS_0);
        Sku sku = skuFeignService.getInfo(order.getSkuId()).getData(Sku.class);
        order.setTotalAmount(sku.getPrice());
        order.setPayAmount(sku.getPrice());
        Stock stock1 = new Stock();
        stock1.setSkuId(sku.getSkuId());
        Stock stockData = stockeignService.list(stock1).getData(Stock.class);
        int insert = 0;
        Long stock = stockData.getStock();
        //todo 锁定库存 redis分布式锁
        if (stock > 0) {
            insert = orderMapper.insert(order);
            stockData.setStock(stock - 1L);
            sku.setSaleCount(sku.getSaleCount()+1L);
            stockeignService.edit(stockData);
        }
        if (insert > 0){
            redisService.setCacheObject(String.format(RedisConstant.ORDER_SN_FORMAT_STRING,orderSn),orderSn,6L, TimeUnit.HOURS);
        }
        rabbitTemplate.convertAndSend("mall.order.exchange","",orderSn);
        log.info("创建订单SN:{}-时间{}",orderSn,new Date());
        return insert;
    }
}