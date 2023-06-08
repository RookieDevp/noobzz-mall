//package cn.noobzz.order.handler;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Component;
//
///**
// * @author: ZZJ
// * @date: 2023/06/07
// * @desc:
// */
//@Component
//@Slf4j
//@RocketMQMessageListener(consumerGroup = "ORDER_CONSUMER", topic = "OrderTopic")
//public class OrderHandler implements RocketMQListener<String> {
//    @Override
//    public void onMessage(String s) {
//      log.info("msg:{}",s);
//    }
//}
