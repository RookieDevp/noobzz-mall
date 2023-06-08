package cn.noobzz.order.handler;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;

/**
 * @author: ZZJ
 * @date: 2023/06/07
 * @desc:
 */
@RabbitListener(queues = "mall.order.cancel.queue")
@Component
@Slf4j
public class OrderQueueHandler {

    @RabbitHandler
    @Transactional(rollbackFor = Exception.class)
    public void cancelOrder(String data, Message message, Channel channel) throws IOException {
        //  如果手动ACK,消息会被监听消费,但是消息在队列中依旧存在,如果 未配置 acknowledge-mode 默认是会在消费完毕后自动ACK掉
        final long deliveryTag = message.getMessageProperties().getDeliveryTag();
        log.info("取消订单SN:{}-时间{}",data,new Date());
        channel.basicAck(deliveryTag, false);
    }
}
