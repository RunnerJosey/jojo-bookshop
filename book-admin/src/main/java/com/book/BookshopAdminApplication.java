package com.book;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
@MapperScan(basePackages="com.book.dao")
public class BookshopAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookshopAdminApplication.class,args);
        log.info("===================本地开放开发平台启动成功==============");
    }
}
