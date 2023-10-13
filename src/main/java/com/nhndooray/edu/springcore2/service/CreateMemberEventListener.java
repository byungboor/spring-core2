package com.nhndooray.edu.springcore2.service;

import com.nhndooray.edu.springcore2.event.CreateMemberEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// TODO - 05 : event listener 는 스프링 빈이어야 합니다.
public class CreateMemberEventListener  {

    // TODO - 06 : 애너테이션을 사용하여 CreateMemberEvent 객체를 수신해주세요.
    public void onMemberCreated(CreateMemberEvent event) {
        System.out.println("------EVENT--->>> Created Member. event : " +  event.toString());
    }
}
