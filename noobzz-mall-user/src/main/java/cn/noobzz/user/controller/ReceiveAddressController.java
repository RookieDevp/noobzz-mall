package cn.noobzz.user.controller;

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
import cn.noobzz.mall.core.domain.ReceiveAddress;
import cn.noobzz.user.service.IReceiveAddressService;
import cn.noobzz.mall.core.base.BaseController;
import cn.noobzz.mall.core.base.Result;

/**
 * 收货地址Controller
 * 
 * @author ZZJ
 * @date 2023-05-12 17:47:36
 */
@RestController
@RequestMapping("/address")
public class ReceiveAddressController extends BaseController
{
    @Autowired
    private IReceiveAddressService receiveAddressService;

    /**
     * 查询收货地址列表
     */
    @GetMapping("/list")
    public Result list(ReceiveAddress receiveAddress)
    {
       return toAjax( receiveAddressService.list());
    }

    /**
     * 获取收货地址详细信息
     */
    @GetMapping(value = "/{addressId}")
    public Result getInfo(@PathVariable("addressId") Long addressId)
    {
        return Result.success(receiveAddressService.getById(addressId));
    }

    /**
     * 新增收货地址
     */
    @PostMapping
    public Result add(@RequestBody ReceiveAddress receiveAddress)
    {
        return toAjax(receiveAddressService.save(receiveAddress));
    }

    /**
     * 修改收货地址
     */
    @PutMapping
    public Result edit(@RequestBody ReceiveAddress receiveAddress)
    {
        return toAjax(receiveAddressService.updateById(receiveAddress));
    }

    /**
     * 删除收货地址
     */
	@DeleteMapping("/{addressIds}")
    public Result remove(@PathVariable Long[] addressIds)
    {
        return toAjax(receiveAddressService.removeByIds(Arrays.asList(addressIds)));
    }
}
