package com.nhndooray.edu.springcore2.job;

import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class ScheduledApplication01 {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");

    @PostConstruct
    public void printConstructionTime() {
        System.out.println("------------ " + LocalDateTime.now().format(dtf) + ", Thread Name : " + Thread.currentThread().getName());
    }

    // TODO - 01 :
    //  condition
    //      - fixedDelay 의 경우
    //      - single thread 인 경우
    //      - fixed delay < execution time
    @Scheduled(initialDelay = 10000L, fixedDelay = 3000, timeUnit = TimeUnit.MILLISECONDS)
    public void printFixedDelay() throws InterruptedException {
        System.out.println("------------ " + LocalDateTime.now().format(dtf) + ", Thread Name : " + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(4);
    }
}
