package cn.noobzz.mall.pay.controller;

import cn.hutool.core.map.MapUtil;
import cn.noobzz.mall.core.base.Result;
import cn.noobzz.mall.core.domain.Order;
import cn.noobzz.mall.pay.config.AlipayConfiguration;
import cn.noobzz.mall.pay.service.IAlipayService;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZZJ
 * @date: 2023/06/09
 * @desc:
 */
@RestController
@RequestMapping("/pay")
public class AlipayController {

    @Autowired
    private IAlipayService alipayService;


    @GetMapping("/alipay")
    public Result alipay(@RequestParam("orderSn") String orderSn) throws AlipayApiException {
        return Result.success(alipayService.alipay(orderSn));
    }

    @GetMapping("/return")
    public Result alipayReturn(HttpServletRequest request) throws AlipayApiException {
        Map<String, String[]> paramsMap = request.getParameterMap();
        Map<String, String> newMap = new HashMap<>(paramsMap.size());
        for (Map.Entry<String, String[]> entry : paramsMap.entrySet()) {
            newMap.put(entry.getKey(), String.join(",", entry.getValue()));
        }
        return Result.success(alipayService.alipayReturn(newMap));
    }
}
