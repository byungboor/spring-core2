package com.nhndooray.edu.springcore2.service;

import com.nhndooray.edu.springcore2.event.CreateMemberEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CreateMemberEventListener {

    @EventListener
    public void onMemberCreated1(CreateMemberEvent event) throws InterruptedException {
        // TODO - 02
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Event Listener : [" + Thread.currentThread().getName() + "] , " + event);
    }

    @EventListener
    public void onMemberCreated2(CreateMemberEvent event) throws InterruptedException {
        // TODO - 03
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Event Listener : [" + Thread.currentThread().getName() + "] , " + event);
    }

}
