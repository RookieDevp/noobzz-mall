package cn.noobzz.mall.pay.service;

import cn.noobzz.mall.core.domain.Order;
import com.alipay.api.AlipayApiException;

import java.util.Map;

/**
 * @author: ZZJ
 * @date: 2023/06/09
 * @desc:
 */
public interface IAlipayService {

    String alipay(String orderSn) throws AlipayApiException;

    boolean alipayReturn(Map<String, String> newMap) throws AlipayApiException;
}
