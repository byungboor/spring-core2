package com.nhndooray.edu.springcore2.service;

import com.nhndooray.edu.springcore2.domain.Member;
import com.nhndooray.edu.springcore2.domain.Password;
import com.nhndooray.edu.springcore2.domain.PrimaryKey;
import com.nhndooray.edu.springcore2.repository.MemberRepository;
import com.nhndooray.edu.springcore2.repository.PasswordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateMemberService {

    private final MemberRepository memberRepository;
    private final PasswordRepository passwordRepository;

    // TODO - 02 : @Async 애너테이션 적용
    @Async
    @Transactional
    public Member create(CreateMemberCommand command) {

        // TODO - 03 : 런타임시 Thread 이름을 확인
        System.out.println("------------------------      create method executed by : " + Thread.currentThread().getName());

        Member member = new Member(command.userCode());
        memberRepository.insert(member);

        Password password = new Password(member, command.password());
        passwordRepository.insert(password);

        System.out.println("------------------------      create method done");
        return member;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
