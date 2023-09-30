package com.nhndooray.edu.springcore2.config;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

public class RedisCacheErrorHandler implements CacheErrorHandler {

    // TODO - 02 : 구현
    @Override
    public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
        exception.printStackTrace();
    }

    @Override
    public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
        exception.printStackTrace();
    }

    @Override
    public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
        exception.printStackTrace();
    }

    @Override
    public void handleCacheClearError(RuntimeException exception, Cache cache) {
        exception.printStackTrace();
    }
}
