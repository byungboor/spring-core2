package com.nhndooray.edu.springcore2.service;

import com.nhndooray.edu.springcore2.event.CreateMemberEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CreateMemberEventListener {

    @EventListener
    public void onMemberCreated(CreateMemberEvent event) {
        // TODO - 03
        System.out.println("Event Listener : [" + Thread.currentThread().getName() + "] , " + event);
    }

}
