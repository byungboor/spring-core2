package com.nhndooray.edu.springcore2;

import com.nhndooray.edu.springcore2.domain.Member;
import com.nhndooray.edu.springcore2.repository.MemberRepository;
import com.nhndooray.edu.springcore2.repository.PasswordRepository;
import com.nhndooray.edu.springcore2.service.CreateMemberCommand;
import com.nhndooray.edu.springcore2.service.CreateMemberService;
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

        System.out.println("start --------------------------------------------");
        service.getAllMembers();
        service.getAllMembers();
        service.getAllMembers();
        System.out.println("--------------------------------------------------");

        CacheManager cacheManager = ctxt.getBean("cacheManager", CacheManager.class);
        System.out.println("CacheManager implementation class : " + cacheManager.getClass().getCanonicalName());

        cacheManager.getCacheNames().stream()
                .forEach(name -> System.out.println("cache name : " + name));
        System.out.println("--------------------------------------------------");

        // TODO - 01 : Cache 구현 클래스 확인
        Cache cache = cacheManager.getCache("account.members");
        System.out.println("Cache implementation class : " + cache.getClass().getCanonicalName());

        ConcurrentMapCache concurrentMapCache = ConcurrentMapCache.class.cast(cache);
        ConcurrentMap<SimpleKey, List<Member>> map = ConcurrentMap.class.cast(concurrentMapCache.getNativeCache());

        // TODO - 02 : 정보 확인
        System.out.println("Map size : " + map.size());
        map.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        System.out.println("end   --------------------------------------------");
    }

}
