package com.nhndooray.edu.springcore2.event;

import lombok.ToString;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@ToString
public abstract class AbstractEvent {

    private final LocalDateTime occurredAt;

    public AbstractEvent() {
        this.occurredAt = LocalDateTime.now();
    }

    public AbstractEvent(LocalDateTime occurredAt) {
        Assert.notNull(occurredAt, "occurredAt can't be null");
        this.occurredAt = occurredAt;
    }

    public final LocalDateTime getOccurredAt() {
        return occurredAt;
    }
}
