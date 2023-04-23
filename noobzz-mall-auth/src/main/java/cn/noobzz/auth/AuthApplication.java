package cn.noobzz.auth;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.oauth2.SaOAuth2Manager;
import cn.dev33.satoken.oauth2.config.SaOAuth2Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: ZZJ
 * @date: 2023/04/21
 * @desc:
 */
@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class,args);
        System.out.println("AuthApplication认证服务已启动咯！");
    }
}
