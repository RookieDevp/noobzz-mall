package cn.noobzz.order.handler;

import cn.noobzz.mall.core.domain.Order;
import cn.noobzz.order.mapper.OrderMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

/**
 * @author: ZZJ
 * @date: 2023/06/10
 * @desc:
 */
@Slf4j
@Component
@RabbitListener(queues = "mall.order.submit.queue")
public class OrderSubmitHandler {

    @Autowired
    private OrderMapper orderMapper;

    @RabbitHandler
    @Transactional(rollbackFor = Exception.class)
    public void cancelOrder(String data, Message message, Channel channel) throws IOException {
        //  如果手动ACK,消息会被监听消费,但是消息在队列中依旧存在,如果 未配置 acknowledge-mode 默认是会在消费完毕后自动ACK掉
        final long deliveryTag = message.getMessageProperties().getDeliveryTag();
        log.info("支付订单SN:{}-时间{}",data,new Date());
        Order order = orderMapper.selectOne(new QueryWrapper<Order>().eq("order_sn",data));
        if (Objects.nonNull(order) && "0".equals(order.getStatus())){
            order.setOrderStatus("1");
            orderMapper.updateById(order);
            log.info("支付订单SN:{}更新成功！！！-时间{}",data,new Date());
        }
        channel.basicAck(deliveryTag, false);
    }
}
