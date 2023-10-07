package com.nhndooray.edu.springcore2.job;

import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class ScheduledApplication02 {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");


    @PostConstruct
    public void printConstructionTime(){
        System.out.println("------------ " + LocalDateTime.now().format(dtf) + ", Thread Name : " + Thread.currentThread().getName());
    }

    // TODO - 04
    @Scheduled(initialDelay = 10L, fixedRate = 3L, timeUnit = TimeUnit.SECONDS)
    public void printFixedRate() throws InterruptedException {
        System.out.println("------------ " + LocalDateTime.now().format(dtf) + ", Thread Name : " + Thread.currentThread().getName());
    }
}
