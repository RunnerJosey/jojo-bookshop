package com.book;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication(scanBasePackages = "com.book")
@Slf4j
@MapperScan(basePackages="com.book.dao")
public class BookshopAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookshopAdminApplication.class,args);


    }
}
