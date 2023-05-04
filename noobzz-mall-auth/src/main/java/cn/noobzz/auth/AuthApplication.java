package cn.noobzz.auth;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.oauth2.SaOAuth2Manager;
import cn.dev33.satoken.oauth2.config.SaOAuth2Config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author: ZZJ
 * @date: 2023/04/21
 * @desc:
 */
@MapperScan(value = "cn.noobzz.user.mapper")
@SpringBootApplication
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class,args);
        System.out.println("AuthApplication认证服务已启动咯！");
        System.out.println(SaOAuth2Manager.getConfig());
    }
}
