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
import cn.noobzz.mall.core.domain.Sku;
import cn.noobzz.product.service.ISkuService;
import cn.noobzz.mall.core.base.BaseController;
import cn.noobzz.mall.core.base.Result;

/**
 * 商品SKUController
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:55
 */
@RestController
@RequestMapping("/sku")
public class SkuController extends BaseController
{
    @Autowired
    private ISkuService skuService;

    /**
     * 查询商品SKU列表
     */
    @GetMapping("/list")
    public Result list(Sku sku)
    {
       return toAjax( skuService.list());
    }

    /**
     * 获取商品SKU详细信息
     */
    @GetMapping(value = "/{skuId}")
    public Result getInfo(@PathVariable("skuId") Long skuId)
    {
        return Result.success(skuService.getById(skuId));
    }

    /**
     * 新增商品SKU
     */
    @PostMapping
    public Result add(@RequestBody Sku sku)
    {
        return toAjax(skuService.save(sku));
    }

    /**
     * 修改商品SKU
     */
    @PutMapping
    public Result edit(@RequestBody Sku sku)
    {
        return toAjax(skuService.updateById(sku));
    }

    /**
     * 删除商品SKU
     */
	@DeleteMapping("/{skuIds}")
    public Result remove(@PathVariable Long[] skuIds)
    {
        return toAjax(skuService.removeByIds(Arrays.asList(skuIds)));
    }
}
