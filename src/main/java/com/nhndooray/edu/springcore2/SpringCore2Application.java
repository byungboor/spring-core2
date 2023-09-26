package com.nhndooray.edu.springcore2;

import com.nhndooray.edu.springcore2.repository.MemberRepository;
import com.nhndooray.edu.springcore2.repository.PasswordRepository;
import com.nhndooray.edu.springcore2.service.CreateMemberCommand;
import com.nhndooray.edu.springcore2.service.CreateMemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCore2Application {

    public static void main(String[] args) {
        ApplicationContext ctxt = SpringApplication.run(SpringCore2Application.class, args);
        CreateMemberService service = ctxt.getBean("createMemberService", CreateMemberService.class);

        // TODO - 3 : 캐시가 정상적으로 동작함을 확인한다.
        System.out.println("start --------------------------------------------");
        service.getAllMembers();
        service.getAllMembers();
        service.getAllMembers();
        System.out.println("--------------------------------------------------");

        CacheManager cacheManager = ctxt.getBean("cacheManager", CacheManager.class);
        System.out.println("CacheManager implementation class : " + cacheManager.getClass().getCanonicalName());

        cacheManager.getCacheNames().stream()
                .forEach(name -> System.out.println("cache name : " + name));

        System.out.println("end   --------------------------------------------");
    }

}
