package cn.noobzz.order.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.noobzz.order.mapper.OrderMapper;
import cn.noobzz.mall.core.domain.Order;
import cn.noobzz.order.service.IOrderService;

/**
 * 订单信息Service业务层处理
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:54
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

}