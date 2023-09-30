package com.nhndooray.edu.springcore2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhndooray.edu.springcore2.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.serializer.*;

import java.util.List;

public class SerializeTest {

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    public void test() {
        MemberValue member = new MemberValue(123123L, "byungboo.kim");

        var genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        System.out.println(new String(genericJackson2JsonRedisSerializer.serialize(member)));

        System.out.println("------------------------------------------------------------------------------------");

        var genericJackson2JsonRedisSerializer2 = new GenericJackson2JsonRedisSerializer(objectMapper);
        System.out.println(new String(genericJackson2JsonRedisSerializer2.serialize(member)));

        System.out.println("------------------------------------------------------------------------------------");

        var jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(objectMapper, MemberValue.class);
        System.out.println(new String(jackson2JsonRedisSerializer.serialize(member)));

        System.out.println("------------------------------------------------------------------------------------");

        var stringRedisSerializer = new StringRedisSerializer();
        System.out.println(new String(stringRedisSerializer.serialize(member.toString())));

    }
}
