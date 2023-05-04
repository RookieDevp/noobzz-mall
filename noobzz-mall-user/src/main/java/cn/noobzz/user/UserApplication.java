package cn.noobzz.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: ZZJ
 * @date: 2023/04/28
 * @desc:
 */
@MapperScan("cn.noobzz.user.mapper")
@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
        System.out.println("UserApplication用户服务已启动！");
    }
}
