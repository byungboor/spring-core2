package com.nhndooray.edu.springcore2.service;

import com.nhndooray.edu.springcore2.event.CreateMemberEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CreateMemberEventPublisher {

    private final ApplicationEventPublisher publisher;

    public void publish(CreateMemberEvent createMemberEvent) {

        if (Objects.nonNull(createMemberEvent)) {
            // TODO - 02
            System.out.println("Event Publisher : [" + Thread.currentThread().getName() + "] , " + createMemberEvent);
            publisher.publishEvent(createMemberEvent);
        }
    }
}
