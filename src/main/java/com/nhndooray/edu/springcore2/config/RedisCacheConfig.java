package com.nhndooray.edu.springcore2.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhndooray.edu.springcore2.cache.interceptor.MemberKeyGenerator;
import com.nhndooray.edu.springcore2.config.properties.RedisCacheConfigProperties;
import io.lettuce.core.ClientOptions;
import io.lettuce.core.SocketOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@EnableCaching
@Configuration
@RequiredArgsConstructor
public class RedisCacheConfig {

    private final RedisCacheConfigProperties properties;

    @Bean
    public KeyGenerator memberKeyGenerator() {
        return new MemberKeyGenerator();
    }

    // TODO - 05 : JSON 데이터 변환을 위한 ObjectMapper 와 java.time 패키지 변환을 위한 JavaTimeModule 추가.
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper;
    }

    // TODO - 06 : LettuceConnectionFactory 설정.
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {

        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(properties.getHost());
        configuration.setPort(properties.getPort());
        // 생략
        // configuration.setUsername(properties.getUsername());
        // configuration.setPassword(properties.getPassword());

        LettuceClientConfiguration clientConfiguration = LettuceClientConfiguration.builder()
                .clientOptions(
                        ClientOptions.builder().socketOptions(
                                        // connection timeout 설정
                                        SocketOptions.builder().connectTimeout(properties.getConnectionTimeout()).build())
                                .build()
                )
                // command timeout 설정
                .commandTimeout(properties.getTimeout())
                .build();

        return new LettuceConnectionFactory(configuration, clientConfiguration);
    }

    // TODO - 07 : cacheManager 설정.
    @Bean
    public CacheManager cacheManager() {

        var keySerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());
        var valueSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer(objectMapper()));

        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                // TTL 설정.
                .entryTtl(Duration.ofHours(1))
                .serializeKeysWith(keySerializationPair)
                .serializeValuesWith(valueSerializationPair);

        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory())
                .withCacheConfiguration("members", redisCacheConfiguration)
                .withCacheConfiguration("members:user-codes", redisCacheConfiguration)
                .build();
    }
}
