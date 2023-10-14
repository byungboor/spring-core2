package com.nhndooray.edu.springcore2.service;

import com.nhndooray.edu.springcore2.event.CreateMemberEvent;
import com.nhndooray.edu.springcore2.event.MemberEventErrorException;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CreateMemberEventListener {

    @EventListener
    public void onMemberCreated(CreateMemberEvent event) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);

        // TODO - 03 : 에러 발생
        if (true) {
            System.out.println("---> Trigger Exception ");
            throw new MemberEventErrorException("Error occurred", event);
        }

        System.out.println("Event Listener : [" + Thread.currentThread().getName() + "] , " + event);
    }
}
