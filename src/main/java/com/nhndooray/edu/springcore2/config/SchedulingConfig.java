package com.nhndooray.edu.springcore2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableScheduling
// TODO - 01.
//  - SchedulingConfigurer 인터페이스를 implements 하고 configureTasks() 를 override 합니다.
//  - configureTasks() 의 인자 ScheduledTaskRegistrar 의 setTaskScheduler() 를 사용하여, 다음 ThreadPoolTaskScheduler bean 를 주입합니다.
public class SchedulingConfig implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setTaskScheduler(taskScheduler());
    }


    // TODO - 02.
    //  - ThreadPoolTaskScheduler 스프링 빈을 만듭니다. ThreadPoolTaskScheduler 에서 제공하는 메서드를 사용해서 설정합니다.
    //  - pool size 를 10으로 설정하세요.
    //  - 스레드의 prefix 를 "TaskScheduler-" 으로 설정하세요.
    //  - waitForJobsToCompleteOnShutdown 설정을 true 로 하세요.
    //  - Bean 초기화 단계에서 initialize() 메서드를 호출합니다.
    //  - Bean 종료 단계에서 destroy() 메서드를 호출합니다.
    @Bean(initMethod = "initialize", destroyMethod = "destroy")
    public ThreadPoolTaskScheduler taskScheduler() {
        var scheduler = new ThreadPoolTaskScheduler();

        scheduler.setPoolSize(10);
        scheduler.setThreadNamePrefix("TaskScheduler-");
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        return scheduler;
    }
}
