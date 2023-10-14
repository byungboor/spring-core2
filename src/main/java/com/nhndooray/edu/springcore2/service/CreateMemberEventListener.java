package com.nhndooray.edu.springcore2.service;

import com.nhndooray.edu.springcore2.event.CreateMemberEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CreateMemberEventListener {

    // TODO - 01
    @EventListener(condition = "#event.userCode == 'byungboo.kim'")
    public void onMemberCreatedForMember(CreateMemberEvent event) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Event Listener : [" + Thread.currentThread().getName() + "] for Byungboo.kim");
    }

    // TODO - 02
    @EventListener(condition = "#event.userCode != 'byungboo.kim'")
    public void onMemberCreated(CreateMemberEvent event) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Event Listener : [" + Thread.currentThread().getName() + "] Not for Byungboo.kim");
    }
}
