package com.nhndooray.edu.springcore2.config;

import com.nhndooray.edu.springcore2.cache.interceptor.MemberKeyGenerator;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO - 03 : enable caching
@EnableCaching
@Configuration
public class RedisCacheConfig {

    @Bean
    public KeyGenerator memberKeyGenerator() {
        return new MemberKeyGenerator();
    }
}
