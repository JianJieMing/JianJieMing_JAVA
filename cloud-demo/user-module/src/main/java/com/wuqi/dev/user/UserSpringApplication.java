package com.wuqi.dev.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 创建人: 武奇
 * 创建事件: 2018/11/5
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserSpringApplication.class, args);
    }
}
