package com.nhndooray.edu.springcore2;

import com.nhndooray.edu.springcore2.job.ScheduledApplication01;
import com.nhndooray.edu.springcore2.job.ScheduledApplication02;
import com.nhndooray.edu.springcore2.job.ScheduledApplication03;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCore2Application {

    public static void main(String[] args) {
        ApplicationContext ctxt = SpringApplication.run(SpringCore2Application.class, args);
    }

    @Bean
    public Object scheduledApplication() {

        Object job = new ScheduledApplication01();
//        Object job = new ScheduledApplication02();
//        Object job = new ScheduledApplication03();

        return job;
    }
}
