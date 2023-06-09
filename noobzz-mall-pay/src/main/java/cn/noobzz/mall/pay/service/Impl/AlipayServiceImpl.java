package cn.noobzz.mall.pay.service.Impl;

import cn.hutool.core.date.DateUtil;
import cn.noobzz.common.redis.service.RedisService;
import cn.noobzz.mall.core.domain.Order;
import cn.noobzz.mall.pay.config.AlipayConfiguration;
import cn.noobzz.mall.pay.service.IAlipayService;
import com.alibaba.fastjson2.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: ZZJ
 * @date: 2023/06/09
 * @desc:
 */
@Service
public class AlipayServiceImpl implements IAlipayService {

    @Autowired
    private AlipayClient alipayClient;

    @Autowired
    private AlipayConfiguration alipayConfiguration;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisService redisService;

    @Override
    public String alipay(String orderSn) throws AlipayApiException {
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
//异步接收地址，仅支持http/https，公网可访问
//        request.setNotifyUrl("");
////同步跳转地址，仅支持http/https
        request.setReturnUrl("https://52v1052j42.zicp.fun/pay/pay/return");
/******必传参数******/
        JSONObject bizContent = new JSONObject();
//商户订单号，商家自定义，保持唯一性
        bizContent.put("out_trade_no", orderSn);
//支付金额，最小值0.01元
        bizContent.put("total_amount", 100);
//订单标题，不可使用特殊符号
        bizContent.put("subject", "测试商品");
//电脑网站支付场景固定传值FAST_INSTANT_TRADE_PAY
        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");

/******可选参数******/
//bizContent.put("time_expire", "2022-08-01 22:00:00");

//// 商品明细信息，按需传入
//JSONArray goodsDetail = new JSONArray();
//JSONObject goods1 = new JSONObject();
//goods1.put("goods_id", "goodsNo1");
//goods1.put("goods_name", "子商品1");
//goods1.put("quantity", 1);
//goods1.put("price", 0.01);
//goodsDetail.add(goods1);
//bizContent.put("goods_detail", goodsDetail);

//// 扩展信息，按需传入
//JSONObject extendParams = new JSONObject();
//extendParams.put("sys_service_provider_id", "2088511833207846");
//bizContent.put("extend_params", extendParams);

        request.setBizContent(bizContent.toString());
        AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
        if (response.isSuccess()) {
            System.out.println(response.getBody());
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return response.getBody();
    }

    @Override
    public boolean alipayReturn(Map<String, String> newMap) throws AlipayApiException {
        //调用SDK验证签名
        boolean  signVerified = AlipaySignature.rsaCheckV1(newMap, alipayConfiguration.getPublicKey(), alipayConfiguration.getCharset(), alipayConfiguration.getSignType());
        if (signVerified){
            // TODO 验签成功后，按照支付结果异步通知中的描述，对支付结果中的业务内容进行二次校验，校验成功后在response中返回success并继续商家自身业务处理，校验失败返回failure
            rabbitTemplate.convertAndSend("mall.order.exchange","submit",newMap.get("out_trade_no"));
        } else {
            // TODO 验签失败则记录异常日志，并在response中返回failure.
        }
        return false;
    }
}
