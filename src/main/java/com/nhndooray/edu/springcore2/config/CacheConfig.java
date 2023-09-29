package com.nhndooray.edu.springcore2.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.nhndooray.edu.springcore2.cache.interceptor.MemberKeyGenerator;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.List;

// TODO - 02 : disable CaffeineCache Configuration
//@EnableCaching
//@Configuration
public class CacheConfig {

    @Bean
    public KeyGenerator memberKeyGenerator() {
        return new MemberKeyGenerator();
    }

    @Bean
    public CacheManager cacheManager() {

        CaffeineCache membersCaffeineCache = new CaffeineCache("members", memberCache());
        CaffeineCache userCodeCaffeineCache = new CaffeineCache("members:user-codes", userCodeCache());

        SimpleCacheManager simpleCacheManager = new SimpleCacheManager(); // vs CaffeineCacheManager.java
        simpleCacheManager.setCaches(List.of(userCodeCaffeineCache, membersCaffeineCache));

        return simpleCacheManager;
    }

    @Bean
    public Cache memberCache() {
        return Caffeine.newBuilder()
                .initialCapacity(100)
                .maximumSize(300)
                .expireAfterWrite(Duration.ofHours(1))
                .recordStats()
                .build();
    }

    @Bean
    public Cache userCodeCache() {
        return Caffeine.newBuilder()
                .initialCapacity(100)
                .maximumSize(300)
                .expireAfterWrite(Duration.ofHours(1))
                .recordStats()
                .build();
    }
}
