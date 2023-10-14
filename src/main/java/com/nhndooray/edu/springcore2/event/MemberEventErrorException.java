package com.nhndooray.edu.springcore2.event;

import lombok.Getter;
@Getter
public class MemberEventErrorException extends RuntimeException {

    private CreateMemberEvent event;

    public MemberEventErrorException(String message, CreateMemberEvent event) {
        super(message);
        this.event = event;
    }

    public MemberEventErrorException(String message, Throwable cause, CreateMemberEvent event) {
        super(message, cause);
        this.event = event;
    }
}
