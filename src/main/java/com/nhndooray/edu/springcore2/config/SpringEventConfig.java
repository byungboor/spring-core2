package com.nhndooray.edu.springcore2.config;

import com.nhndooray.edu.springcore2.event.MemberEventErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class SpringEventConfig {

    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.setTaskExecutor(eventThreadPoolTaskExecutor());
        eventMulticaster.setErrorHandler(new MemberEventErrorHandler());
        return eventMulticaster;
    }

    @Bean
    public TaskExecutor eventThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(10);
        executor.setCorePoolSize(10);
        executor.setQueueCapacity(30);
        executor.setThreadNamePrefix("EVENT-THREAD-POOL-");
        return executor;
    }
}
