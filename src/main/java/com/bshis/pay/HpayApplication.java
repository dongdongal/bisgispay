package com.bshis.pay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync//开启对异步任务的支持
@EnableCaching//开启缓存
@EnableScheduling
public class HpayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HpayApplication.class, args);
    }
}
