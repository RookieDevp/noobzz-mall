package cn.noobzz.order.controller;

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
import cn.noobzz.mall.core.domain.Order;
import cn.noobzz.order.service.IOrderService;
import cn.noobzz.mall.core.base.BaseController;
import cn.noobzz.mall.core.base.Result;

/**
 * 订单信息Controller
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:54
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController
{
    @Autowired
    private IOrderService orderService;

    /**
     * 查询订单信息列表
     */
    @GetMapping("/list")
    public Result list(Order order)
    {
       return toAjax( orderService.list());
    }

    /**
     * 获取订单信息详细信息
     */
    @GetMapping(value = "/{orderId}")
    public Result getInfo(@PathVariable("orderId") Long orderId)
    {
        return Result.success(orderService.getById(orderId));
    }

    /**
     * 新增订单信息
     */
    @PostMapping
    public Result add(@RequestBody Order order)
    {
        return toAjax(orderService.save(order));
    }

    /**
     * 修改订单信息
     */
    @PutMapping
    public Result edit(@RequestBody Order order)
    {
        return toAjax(orderService.updateById(order));
    }

    /**
     * 删除订单信息
     */
	@DeleteMapping("/{orderIds}")
    public Result remove(@PathVariable Long[] orderIds)
    {
        return toAjax(orderService.removeByIds(Arrays.asList(orderIds)));
    }
}
