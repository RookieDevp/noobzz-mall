package cn.noobzz.order.service;

import cn.noobzz.mall.core.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 订单信息Service接口
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:54
 */
public interface IOrderService extends IService<Order> {

    int saveOrder(Order order);
}