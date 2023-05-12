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
import cn.noobzz.mall.core.domain.Category;
import cn.noobzz.product.service.ICategoryService;
import cn.noobzz.mall.core.base.BaseController;
import cn.noobzz.mall.core.base.Result;

/**
 * 商品分类Controller
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:54
 */
@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController
{
    @Autowired
    private ICategoryService categoryService;

    /**
     * 查询商品分类列表
     */
    @GetMapping("/list")
    public Result list(Category category)
    {
       return toAjax( categoryService.list());
    }

    /**
     * 获取商品分类详细信息
     */
    @GetMapping(value = "/{categoryId}")
    public Result getInfo(@PathVariable("categoryId") Long categoryId)
    {
        return Result.success(categoryService.getById(categoryId));
    }

    /**
     * 新增商品分类
     */
    @PostMapping
    public Result add(@RequestBody Category category)
    {
        return toAjax(categoryService.save(category));
    }

    /**
     * 修改商品分类
     */
    @PutMapping
    public Result edit(@RequestBody Category category)
    {
        return toAjax(categoryService.updateById(category));
    }

    /**
     * 删除商品分类
     */
	@DeleteMapping("/{categoryIds}")
    public Result remove(@PathVariable Long[] categoryIds)
    {
        return toAjax(categoryService.removeByIds(Arrays.asList(categoryIds)));
    }
}
