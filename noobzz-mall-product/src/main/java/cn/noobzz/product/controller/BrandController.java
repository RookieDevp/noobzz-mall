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
import cn.noobzz.mall.core.domain.Brand;
import cn.noobzz.product.service.IBrandService;
import cn.noobzz.mall.core.base.BaseController;
import cn.noobzz.mall.core.base.Result;

/**
 * 商品品牌Controller
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:54
 */
@RestController
@RequestMapping("/brand")
public class BrandController extends BaseController
{
    @Autowired
    private IBrandService brandService;

    /**
     * 查询商品品牌列表
     */
    @GetMapping("/list")
    public Result list(Brand brand)
    {
       return toAjax( brandService.list());
    }

    /**
     * 获取商品品牌详细信息
     */
    @GetMapping(value = "/{brandId}")
    public Result getInfo(@PathVariable("brandId") Long brandId)
    {
        return Result.success(brandService.getById(brandId));
    }

    /**
     * 新增商品品牌
     */
    @PostMapping
    public Result add(@RequestBody Brand brand)
    {
        return toAjax(brandService.save(brand));
    }

    /**
     * 修改商品品牌
     */
    @PutMapping
    public Result edit(@RequestBody Brand brand)
    {
        return toAjax(brandService.updateById(brand));
    }

    /**
     * 删除商品品牌
     */
	@DeleteMapping("/{brandIds}")
    public Result remove(@PathVariable Long[] brandIds)
    {
        return toAjax(brandService.removeByIds(Arrays.asList(brandIds)));
    }
}
