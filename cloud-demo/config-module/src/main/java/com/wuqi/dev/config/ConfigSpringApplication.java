package com.wuqi.dev.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 创建人: 武奇
 * 创建事件: 2018/11/5
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigSpringApplication.class, args);
    }
}
