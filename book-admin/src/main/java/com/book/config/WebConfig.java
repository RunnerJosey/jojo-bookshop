package com.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 解决CORS跨域请求问题
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080") // 允许的源
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的 HTTP 方法
                .allowedHeaders("*") // 允许的请求头
                .allowCredentials(true); // 是否允许发送 cookies
    }
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        // 将 /api/** 重定向到 /**
//        registry.addRedirectViewController("/api/{path}", "/{path}")
//                .setStatusCode(HttpStatus.MOVED_PERMANENTLY);
//    }
}