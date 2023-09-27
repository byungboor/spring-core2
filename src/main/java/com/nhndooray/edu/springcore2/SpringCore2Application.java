package com.nhndooray.edu.springcore2;

import com.nhndooray.edu.springcore2.domain.Member;
import com.nhndooray.edu.springcore2.repository.MemberRepository;
import com.nhndooray.edu.springcore2.repository.PasswordRepository;
import com.nhndooray.edu.springcore2.service.CreateMemberCommand;
import com.nhndooray.edu.springcore2.service.CreateMemberService;
import com.nhndooray.edu.springcore2.service.QueryMemberCommand;
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
        CreateMemberService service = ctxt.getBean("createMemberService", CreateMemberService.class);

        // TODO - 0 : 전체 코드 설명. create, query, query
        service.create(new CreateMemberCommand("byungboor", "password!@#123"));
        System.out.println("start --------------------------------------------");
        service.getMember(new QueryMemberCommand("byungboor"));
        service.getMember(new QueryMemberCommand("byungboor"));
        System.out.println("--------------------------------------------------");

        CacheManager cacheManager = ctxt.getBean("cacheManager", CacheManager.class);
        Cache cache = cacheManager.getCache("member");
        ConcurrentMapCache concurrentMapCache = ConcurrentMapCache.class.cast(cache);
        ConcurrentMap<SimpleKey, List<Member>> map = ConcurrentMap.class.cast(concurrentMapCache.getNativeCache());

        System.out.println("Map size : " + map.size());
        map.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        System.out.println("end   --------------------------------------------");
    }

}
