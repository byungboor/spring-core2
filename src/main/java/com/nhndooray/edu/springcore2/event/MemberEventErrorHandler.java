package com.nhndooray.edu.springcore2.event;

import org.springframework.util.ErrorHandler;

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
