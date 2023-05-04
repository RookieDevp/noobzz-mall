package cn.noobzz.gateway.config;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ZZJ
 * @date: 2023/04/22
 * @desc:
 */
@Configuration
public class SaTokenConfigure {

    private static List<String> excludePathList = Arrays.asList(
            "/favicon.ico"
            ,"/auth/oauth2/**"
            ,"/doc.html"
            ,"/auth/v2/api-docs"
            ,"/user/v2/api-docs"
            ,"/swagger-resources/**"
            ,"/user/user/register");

    @Bean
    public SaReactorFilter getSaReactorFilter() {
        return new SaReactorFilter()
                // 拦截地址
                .addInclude("/**")
                /* 拦截全部path */
                // 开放地址
                .setExcludeList(excludePathList)
                // 鉴权方法：每次访问进入
                .setAuth(obj -> {
                    // 登录校验 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
                    SaRouter.match("/**", "/auth/login/doLogin", r -> StpUtil.checkLogin());
                })
                // 异常处理方法：每次setAuth函数出现异常时进入
                .setError(e -> {
                    return SaResult.error(e.getMessage());
                })
                ;
    }
}
