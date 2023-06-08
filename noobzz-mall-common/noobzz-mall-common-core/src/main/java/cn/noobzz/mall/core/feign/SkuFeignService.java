package cn.noobzz.mall.core.feign;

import cn.noobzz.mall.core.base.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: ZZJ
 * @date: 2023/06/06
 * @desc:
 */
@FeignClient(name = "noobzz-mall-product")
public interface SkuFeignService {

    @GetMapping(value = "/sku/{skuId}")
    public Result getInfo(@PathVariable("skuId") Long skuId);
}
