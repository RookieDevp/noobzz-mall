package cn.noobzz.auth.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.noobzz.mall.core.base.BaseController;
import cn.noobzz.mall.core.base.Result;
import cn.noobzz.mall.core.domain.SysUser;
import cn.noobzz.user.mapper.SysUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author: ZZJ
 * @date: 2023/04/22
 * @desc:
 */
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController extends BaseController {

    @Autowired
    private SysUserMapper sysUserMapper;

    @GetMapping("/doLogin")
    public Result doLogin(String username, String password) {
        // TODO 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对 生成的是会话令牌
            QueryWrapper<SysUser> eq = new QueryWrapper<SysUser>().eq("username", username)
                    .eq("password", password);
            log.info("{}:{}",username,password);
            SysUser sysUser = sysUserMapper.selectOne(eq);
            if (Objects.isNull(sysUser)){
                return error("登录失败");
            }else {
                StpUtil.login(sysUser.getUserId());
                SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
                return Result.success(tokenInfo);
            }
    }

    //todo 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @GetMapping("/isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    // 查询 Token 信息  ---- http://localhost:8081/acc/tokenInfo
    @GetMapping("/tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    // 测试注销  ---- http://localhost:8081/acc/logout
    @GetMapping("/logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

    @GetMapping("/checkLogin")
    public SaResult checkLogin() {
        StpUtil.checkLogin();
        return SaResult.ok();
    }

}

