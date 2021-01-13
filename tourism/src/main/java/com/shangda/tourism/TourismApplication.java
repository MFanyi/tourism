package com.shangda.tourism;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.shangda.tourism.dao")
@SpringBootApplication
public class TourismApplication {
    public static void main(String[] args) {
        SpringApplication.run(TourismApplication.class);
    }
}
