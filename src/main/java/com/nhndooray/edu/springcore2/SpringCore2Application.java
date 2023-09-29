package com.nhndooray.edu.springcore2;

import com.nhndooray.edu.springcore2.service.CreateMemberCommand;
import com.nhndooray.edu.springcore2.service.CreateMemberService;
import com.nhndooray.edu.springcore2.service.QueryMemberCommand;
import com.nhndooray.edu.springcore2.service.QueryMemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCore2Application {

    public static void main(String[] args) {
        ApplicationContext ctxt = SpringApplication.run(SpringCore2Application.class, args);
        CreateMemberService createMemberService = ctxt.getBean("createMemberService", CreateMemberService.class);
        QueryMemberService queryMemberService = ctxt.getBean("queryMemberService", QueryMemberService.class);

        createMemberService.create(new CreateMemberCommand("byungboor", "password!@#123"));
        System.out.println("start --------------------------------------------");
        queryMemberService.getMember(new QueryMemberCommand("byungboor"));
        queryMemberService.getMember(new QueryMemberCommand("byungboor"));
        System.out.println("--------------------------------------------------");

        CacheManager cacheManager = ctxt.getBean("cacheManager", CacheManager.class);
        System.out.println(cacheManager.getClass().getCanonicalName());
        Cache cache = cacheManager.getCache("members");
        System.out.println(cache.get("member:user-code:byungboor").get().toString());

        cache = cacheManager.getCache("members:user-codes");
        System.out.println(cache.get("member:user-code:byungboor").get().toString());
        System.out.println("end   --------------------------------------------");

    }
}
