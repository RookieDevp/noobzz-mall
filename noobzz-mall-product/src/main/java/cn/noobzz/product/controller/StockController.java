package cn.noobzz.product.controller;

import java.util.List;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.noobzz.mall.core.domain.Stock;
import cn.noobzz.product.service.IStockService;
import cn.noobzz.mall.core.base.BaseController;
import cn.noobzz.mall.core.base.Result;

/**
 * 商品库存Controller
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:55
 */
@RestController
@RequestMapping("/stock")
public class StockController extends BaseController
{
    @Autowired
    private IStockService stockService;

    /**
     * 查询商品库存列表
     */
    @GetMapping("/list")
    public Result list(Stock stock)
    {
       return toAjax( stockService.list());
    }

    /**
     * 获取商品库存详细信息
     */
    @GetMapping(value = "/{stockId}")
    public Result getInfo(@PathVariable("stockId") Long stockId)
    {
        return Result.success(stockService.getById(stockId));
    }

    /**
     * 新增商品库存
     */
    @PostMapping
    public Result add(@RequestBody Stock stock)
    {
        return toAjax(stockService.save(stock));
    }

    /**
     * 修改商品库存
     */
    @PutMapping
    public Result edit(@RequestBody Stock stock)
    {
        return toAjax(stockService.updateById(stock));
    }

    /**
     * 删除商品库存
     */
	@DeleteMapping("/{stockIds}")
    public Result remove(@PathVariable Long[] stockIds)
    {
        return toAjax(stockService.removeByIds(Arrays.asList(stockIds)));
    }
}
