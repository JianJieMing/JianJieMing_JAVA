package com.lanou3g.tokendemo111.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 铭
 * 2018/11/1 16:37
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    //添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //往拦截器注册器里添加拦截器 addPathPatterns("/index")
        registry.addInterceptor(new MyInterceptor()).excludePathPatterns("/login");
    }

}
