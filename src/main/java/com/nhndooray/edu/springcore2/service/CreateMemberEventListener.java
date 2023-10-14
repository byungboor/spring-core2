package com.nhndooray.edu.springcore2.service;

import com.nhndooray.edu.springcore2.event.CreateMemberEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.concurrent.TimeUnit;

@Component
public class CreateMemberEventListener {


    // TODO - 03 : @EventListener -> @TransactionalEventListener 으로 변경.
    @TransactionalEventListener
    public void onMemberCreated(CreateMemberEvent event) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Event Listener : [" + Thread.currentThread().getName() + "] for Byungboo.kim");
    }

}
