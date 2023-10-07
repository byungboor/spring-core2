package com.nhndooray.edu.springcore2.job;

import jakarta.annotation.PostConstruct;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScheduledApplication03 {

    public static final String EVERY_10_SECOND = "*/10 * * * * * ";

    public final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");

    @PostConstruct
    public void printConstructionTime(){
        System.out.println("------------ " + LocalDateTime.now().format(dtf) + ", Thread Name : " + Thread.currentThread().getName());
    }

    // TODO - 05
    @Scheduled(cron = EVERY_10_SECOND)
    public void printCron() throws InterruptedException {
        System.out.println("------------ " + LocalDateTime.now().format(dtf) + ", Thread Name : " + Thread.currentThread().getName());
    }
}
