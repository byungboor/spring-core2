package com.nhndooray.edu.springcore2.service;

import com.nhndooray.edu.springcore2.domain.Member;
import com.nhndooray.edu.springcore2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QueryMemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    @Cacheable(cacheNames = {"account.members"})
    public List<Member> getAllMembers() {
        System.out.println("Query : getAllMembers");
        return memberRepository.findAll();
    }

    // TODO - 01 :
    //  - getMember() 메서드를 @Cacheable 을 사용하여 캐싱합니다.
    //  - 저장할 Cache 객체의 이름은 'members:user-codes' 와 'members' 입니다.
    //  - 이때 return 값이 null 이면 캐시하지 않습니다.
    //  - key 이름 생성은 MemberKeyGenerator 스프링 빈에 의존합니다.
    //  - 만약 QueryMemberCommand 파라미터의 userCode가 null 이면 캐시하지 않습니다.
    @Transactional(readOnly = true)
    @Cacheable(cacheNames = {"members:user-codes", "members"}, condition = "#command.userCode != null", unless = "#result == null", keyGenerator = "memberKeyGenerator")
    public Optional<Member> getMember(QueryMemberCommand command) {
        System.out.println("Query : getMember");
        return memberRepository.findByUserCode(command.userCode());
    }
}
