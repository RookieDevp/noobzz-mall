//package cn.noobzz.auth.config;
//
//import cn.dev33.satoken.oauth2.config.SaOAuth2Config;
//import cn.dev33.satoken.stp.StpUtil;
//import cn.dev33.satoken.util.SaResult;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author: ZZJ
// * @date: 2023/04/22
// * @desc:
// */
//@Configuration
//public class OAuth2Config {
//
//    @Bean
//    public SaOAuth2Config setSaOAuth2Config(SaOAuth2Config cfg){
//        cfg.
//                // 配置：未登录时返回的View
//                        setNotLoginView(() -> {
//                    String msg = "当前会话在OAuth-Server端尚未登录，请先访问"
//                            + "<a href='/oauth2/doLogin?name=sa&pwd=123456' target='_blank'> doLogin登录 </a>"
//                            + "进行登录之后，刷新页面开始授权";
//                    return msg;
//                }).
//                // 配置：登录处理函数
//                        setDoLoginHandle((name, pwd) -> {
//                    //注意：在setDoLoginHandle函数里如果要获取name, pwd以外的参数，可通过SaHolder.getRequest().getParam("xxx")来获取
//                    if("sa".equals(name) && "123456".equals(pwd)) {
//                        StpUtil.login(10001);
//                        return SaResult.ok();
//                    }
//                    return SaResult.error("账号名或密码错误");
//                }).
//                // 配置：确认授权时返回的View
//                        setConfirmView((clientId, scope) -> {
//                    String msg = "<p>应用 " + clientId + " 请求授权：" + scope + "</p>"
//                            + "<p>请确认：<a href='/oauth2/doConfirm?client_id=" + clientId + "&scope=" + scope + "' target='_blank'> 确认授权 </a></p>"
//                            + "<p>确认之后刷新页面</p>";
//                    return msg;
//                })
//        ;
//        return cfg;
//    }
//
//}
