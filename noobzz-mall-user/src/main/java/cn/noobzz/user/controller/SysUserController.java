package cn.noobzz.user.controller;

import cn.noobzz.mall.core.base.BaseController;
import cn.noobzz.mall.core.base.Result;
import cn.noobzz.mall.core.domain.SysUser;
import cn.noobzz.user.service.Impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author: ZZJ
 * @date: 2023/04/28
 * @desc:
 */
@RestController
@RequestMapping("/user")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @PostMapping("/register")
    public Result register(@RequestBody SysUser sysUser){
        sysUser.setCreateTime(new Date());
        return toAjax(sysUserService.save(sysUser));
    }

    @GetMapping("/getList")
    public Result getList(){
        return toAjax(sysUserService.list());
    }
}
