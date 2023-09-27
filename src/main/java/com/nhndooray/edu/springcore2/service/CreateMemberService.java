package com.nhndooray.edu.springcore2.service;

import com.nhndooray.edu.springcore2.domain.Member;
import com.nhndooray.edu.springcore2.domain.Password;
import com.nhndooray.edu.springcore2.repository.MemberRepository;
import com.nhndooray.edu.springcore2.repository.PasswordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreateMemberService {

    private final MemberRepository memberRepository;
    private final PasswordRepository passwordRepository;

    @Transactional
    public Member create(CreateMemberCommand command) {
        Member member = new Member(command.userCode());
        memberRepository.insert(member);

        Password password = new Password(member, command.password());
        passwordRepository.insert(password);

        return member;
    }

    @Cacheable(cacheNames = {"account.members"})
    public List<Member> getAllMembers() {
        System.out.println("Query : getAllMembers");
        return memberRepository.findAll();
    }

    // TODO - 4 : keyGenerator 속성 설정
    @Cacheable(cacheNames = "member", keyGenerator = "memberKeyGenerator")
    public Optional<Member> getMember(QueryMemberCommand command){
        System.out.println("Query : getMember");
        return memberRepository.findByUserCode(command.userCode());
    }
}
