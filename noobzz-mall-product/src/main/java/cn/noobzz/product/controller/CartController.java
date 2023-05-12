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
import cn.noobzz.mall.core.domain.Cart;
import cn.noobzz.product.service.ICartService;
import cn.noobzz.mall.core.base.BaseController;
import cn.noobzz.mall.core.base.Result;

/**
 * 购物车Controller
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:54
 */
@RestController
@RequestMapping("/cart")
public class CartController extends BaseController
{
    @Autowired
    private ICartService cartService;

    /**
     * 查询购物车列表
     */
    @GetMapping("/list")
    public Result list(Cart cart)
    {
       return toAjax( cartService.list());
    }

    /**
     * 获取购物车详细信息
     */
    @GetMapping(value = "/{cartId}")
    public Result getInfo(@PathVariable("cartId") Long cartId)
    {
        return Result.success(cartService.getById(cartId));
    }

    /**
     * 新增购物车
     */
    @PostMapping
    public Result add(@RequestBody Cart cart)
    {
        return toAjax(cartService.save(cart));
    }

    /**
     * 修改购物车
     */
    @PutMapping
    public Result edit(@RequestBody Cart cart)
    {
        return toAjax(cartService.updateById(cart));
    }

    /**
     * 删除购物车
     */
	@DeleteMapping("/{cartIds}")
    public Result remove(@PathVariable Long[] cartIds)
    {
        return toAjax(cartService.removeByIds(Arrays.asList(cartIds)));
    }
}
