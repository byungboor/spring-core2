package com.nhndooray.edu.springcore2.service;

import com.nhndooray.edu.springcore2.event.CreateMemberEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CreateMemberEventListener  {

    // TODO - 02
    @EventListener
    public void onMemberCreated(CreateMemberEvent event) {
        System.out.println("------EVENT--->>> Created Member. event : " +  event.toString());
    }

    // TODO - 03
    @EventListener
    public void listenMemberCreatedEvent(CreateMemberEvent event){
        System.out.println("------EVENT--->>> listen created member event : " +  event.toString());
    }
}
