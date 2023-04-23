package cn.noobzz.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: ZZJ
 * @date: 2023/04/21
 * @desc:
 */
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
        System.out.println("GatewayApplication网关服务已启动咯！");
    }
}
