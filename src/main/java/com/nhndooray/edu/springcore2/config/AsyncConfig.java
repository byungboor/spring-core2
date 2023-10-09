package com.nhndooray.edu.springcore2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@Configuration
public class AsyncConfig {

    // TODO - 01 : 기본 TaskExecutor 를 설정한다.
    //  - TaskExecutor 구현체로 ThreadPoolTaskExecutor 를 사용한다.
    //  - Bean 의 초기화 메서드에는 ThreadPoolTaskExecutor의 initialize() 를 설정하고 종료 메서드에는 ThreadPoolTaskExecutor의 shutdown() 을 설정한다.
    //  - TaskExecutor의 core size = 10, max size = 20, queue size = 30 으로 설정한다.
    //  - TaskExecutor의 setAwaitTermination 설정을 30초로 한다.
    //  - TaskExecutor의 WaitForTasksToCompleteOnShutdown 을 true 로 변경한다.
    //  - TaskExecutor의 스레드 이름 머릿말을 "default-thread-pool-" 으로 설정한다.
    @Bean(initMethod = "initialize", destroyMethod = "shutdown")
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(30);
        executor.setAwaitTerminationSeconds(30);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix("default-thread-pool-");

        return executor;
    }

    // TODO - 02 : TODO 01 을 참고하여 다른 TaskExecutor 스프링 빈을 생성한다.
    //  - 스프링빈 이름은 memberTaskExecutor 이다.
    //  - memberTaskExecutor 의 스레드 이름 머릿말을 "member-thread-pool-" 으로 설정한다.



}
