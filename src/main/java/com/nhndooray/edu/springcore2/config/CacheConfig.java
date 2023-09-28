package com.nhndooray.edu.springcore2.config;

import com.nhndooray.edu.springcore2.cache.interceptor.MemberKeyGenerator;
import com.nhndooray.edu.springcore2.domain.Member;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CacheConfig {

    @Bean
    public KeyGenerator memberKeyGenerator() {
        return new MemberKeyGenerator();
    }
}
