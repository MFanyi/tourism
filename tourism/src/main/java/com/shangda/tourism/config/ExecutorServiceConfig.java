package com.shangda.tourism.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ExecutorServiceConfig {
    @Bean
    public ExecutorService executorService(){
        ExecutorService es = Executors.newFixedThreadPool(5);
        return es;
    }
}
