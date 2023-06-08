package cn.noobzz.product.controller;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import cn.noobzz.common.redis.constants.RedisConstant;
import cn.noobzz.common.redis.service.RedisService;
import cn.noobzz.mall.core.domain.Brand;
import cn.noobzz.mall.core.domain.Category;
import cn.noobzz.mall.core.domain.Sku;
import cn.noobzz.product.service.ISkuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.noobzz.mall.core.domain.Spu;
import cn.noobzz.product.service.ISpuService;
import cn.noobzz.mall.core.base.BaseController;
import cn.noobzz.mall.core.base.Result;

import javax.annotation.Resource;

/**
 * 商品SPUController
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:55
 */
@RestController
@RequestMapping("/spu")
public class SpuController extends BaseController
{
    @Autowired
    private ISpuService spuService;

    @Resource
    private ISkuService skuService;

    @Autowired
    private RedisService redisService;

    /**
     * 查询商品SPU列表
     */
    @GetMapping("/list")
    public Result list(Spu spu)
    {
        List<Spu> list = spuService.list(new QueryWrapper<Spu>().allEq(BeanUtil.beanToMap(spu,true,true)));
        List<Spu> spuList = list.stream().map(each -> {
            Long brandId = each.getBrandId();
            Long categoryId = each.getCategoryId();
            Brand brand = (Brand) redisService.getCacheObject(String.format(RedisConstant.BRAND_FORMAT_STRING, brandId));
            Category category = (Category) redisService.getCacheObject(String.format(RedisConstant.CATEGORY_FORMAT_STRING, categoryId));
            each.setBrandName(brand.getBrandName());
            each.setCategoryName(category.getCategoryName());
            Long spuId = each.getSpuId();
            List<Sku> skuList = skuService.list(new QueryWrapper<Sku>().eq("spu_id", spuId));
            each.setSkuList(skuList);
            return each;
        }).collect(Collectors.toList());
        return toAjax(spuList);
    }

    /**
     * 获取商品SPU详细信息
     */
    @GetMapping(value = "/{spuId}")
    public Result getInfo(@PathVariable("spuId") Long spuId)
    {
        return Result.success(spuService.getById(spuId));
    }

    /**
     * 新增商品SPU
     */
    @PostMapping
    public Result add(@RequestBody Spu spu)
    {
        return toAjax(spuService.save(spu));
    }

    /**
     * 修改商品SPU
     */
    @PutMapping
    public Result edit(@RequestBody Spu spu)
    {
        return toAjax(spuService.updateById(spu));
    }

    /**
     * 删除商品SPU
     */
	@DeleteMapping("/{spuIds}")
    public Result remove(@PathVariable Long[] spuIds)
    {
        return toAjax(spuService.removeByIds(Arrays.asList(spuIds)));
    }
}
