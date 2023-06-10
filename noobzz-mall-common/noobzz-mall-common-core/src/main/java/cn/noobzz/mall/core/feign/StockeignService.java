package cn.noobzz.mall.core.feign;

import cn.noobzz.mall.core.base.Result;
import cn.noobzz.mall.core.domain.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author: ZZJ
 * @date: 2023/06/06
 * @desc:
 */
@FeignClient(name = "noobzz-mall-product")
@RequestMapping("/stock")
public interface StockeignService {

    @GetMapping(value = "/{stockId}")
    public Result getInfo(@PathVariable("stockId") Long stockId);

    @GetMapping("/list")
    public Result list(Stock stock);

    @PutMapping
    public Result edit(@RequestBody Stock stock);
}
