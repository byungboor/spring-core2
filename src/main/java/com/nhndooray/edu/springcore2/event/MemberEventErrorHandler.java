package com.nhndooray.edu.springcore2.event;

import org.springframework.util.ErrorHandler;

// TODO - 02 : ErrorHandler 인터페이스를 구현하는 클래스
public class MemberEventErrorHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable t) {
        if (MemberEventErrorException.class.isInstance(t)) {
            CreateMemberEvent errorEvent = MemberEventErrorException.class.cast(t).getEvent();
            System.out.println("ERROR on event. EVENT : " + errorEvent);
        } else {
            t.printStackTrace();
        }
    }
}
