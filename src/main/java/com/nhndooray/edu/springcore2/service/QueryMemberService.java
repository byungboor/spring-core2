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

    @Transactional(readOnly = true)
    @Cacheable(cacheNames = {"members:user-codes", "members"}, condition = "#command.userCode != null", unless = "#result == null", keyGenerator = "memberKeyGenerator")
    public Optional<Member> getMember(QueryMemberCommand command) {
        System.out.println("Query : getMember");
        return memberRepository.findByUserCode(command.userCode());
    }
}
