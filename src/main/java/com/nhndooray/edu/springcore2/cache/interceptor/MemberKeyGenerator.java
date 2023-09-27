package com.nhndooray.edu.springcore2.cache.interceptor;

import com.nhndooray.edu.springcore2.service.QueryMemberCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

// TODO - 1 : KeyGenerator 예제
@Slf4j
public class MemberKeyGenerator implements KeyGenerator {

    private final SimpleKeyGenerator simpleKeyGenerator = new SimpleKeyGenerator();

    @Override
    public Object generate(Object target, Method method, Object... params) {

        if (Objects.isNull(params) || params.length == 0)
            return simpleKeyGenerator.generate(target, method, params);

        String key = null;
        try {
            QueryMemberCommand command = QueryMemberCommand.class.cast(params[0]);
            key = "member:user-code:" + command.userCode();
        } catch (Throwable th) {
            // TODO - 2 : fallback 코드. params 는 위치는 항상 바뀔 수 있다.
            key = Arrays.stream(params)
                    .map(Object::toString)
                    .collect(Collectors.joining(":"));
            log.error("error to cast", th);
        } finally {
            return key;
        }
    }
}
