package com.nhndooray.edu.springcore2.service;

import com.nhndooray.edu.springcore2.event.AbstractEvent;
import com.nhndooray.edu.springcore2.event.CreateMemberEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CommonEventListener {

    // TODO - 04
    @EventListener
    public void onMemberCreated(AbstractEvent event) {
        System.out.println("------EVENT--->>> Abstract event : " + event.toString());
    }

}
