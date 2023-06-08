package cn.noobzz.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: ZZJ
 * @date: 2023/05/13
 * @desc:
 */
@EnableFeignClients(basePackages = "cn.noobzz.mall.core.feign")
@MapperScan("cn.noobzz.**.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
