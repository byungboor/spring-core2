package com.nhndooray.edu.springcore2;

import com.nhndooray.edu.springcore2.domain.Member;
import com.nhndooray.edu.springcore2.repository.MemberRepository;
import com.nhndooray.edu.springcore2.repository.PasswordRepository;
import com.nhndooray.edu.springcore2.service.CreateMemberCommand;
import com.nhndooray.edu.springcore2.service.CreateMemberService;
import com.nhndooray.edu.springcore2.service.QueryMemberCommand;
import com.nhndooray.edu.springcore2.service.QueryMemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

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
        queryMemberService.getMember(new QueryMemberCommand("not-found-usercode"));
        queryMemberService.getMember(new QueryMemberCommand("not-found-usercode"));
        System.out.println("--------------------------------------------------");
        queryMemberService.getMember(new QueryMemberCommand(null));
        queryMemberService.getMember(new QueryMemberCommand(null));
        System.out.println("--------------------------------------------------");

        // TODO - 02 : 정상적으로 화면에 출력되는지 확인한다.
        CacheManager cacheManager = ctxt.getBean("cacheManager", CacheManager.class);
        Cache cache = cacheManager.getCache("members");
        System.out.println(cache.get("member:user-code:byungboor").get().toString());

        cache = cacheManager.getCache("members:user-codes");
        System.out.println(cache.get("member:user-code:byungboor").get().toString());

        System.out.println("end   --------------------------------------------");
    }
}
