package com.nhndooray.edu.springcore2.service;

import com.nhndooray.edu.springcore2.event.CreateMemberEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Objects;

// TODO - 02 : 이벤트를 발송하는 EventPublisher 는 Spring 애플리케이션에서 제공하는 ??? 스프링빈을 주입받아야 합니다.
public class CreateMemberEventPublisher {


    public void publish(CreateMemberEvent createMemberEvent) {
        // TODO - 03 : 주입 받은 ??? 스프링 빈의 메서드를 사용하여 createMemberEvent 이벤트를 발송하세요.
        if (Objects.nonNull(createMemberEvent)) {
            //???.publishEvent(xxx)
        }
    }
}
