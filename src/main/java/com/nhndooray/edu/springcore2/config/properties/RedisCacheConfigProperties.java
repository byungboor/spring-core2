package com.nhndooray.edu.springcore2.config.properties;

import lombok.Getter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import java.time.Duration;

@Getter
@ToString
// TODO - 03 : custom property 를 저장하기 위한 프러퍼티 클래스.
@ConfigurationProperties(prefix = "account.cache.redis")
public class RedisCacheConfigProperties {

    private String host;
    private String username;
    private String password;
    private Integer port;
    private Duration timeout;
    private Duration connectionTimeout;

    @ConstructorBinding
    public RedisCacheConfigProperties(String host, String username, String password, Integer port, Duration timeout, Duration connectionTimeout) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;
        this.timeout = timeout;
        this.connectionTimeout = connectionTimeout;
    }
}
