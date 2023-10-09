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

    @Async
    @Transactional
    public void create(CreateMemberCommand command) {

        System.out.println("------------------------      create method executed by : " + Thread.currentThread().getName());

        Member member = new Member(command.userCode());
        memberRepository.insert(member);

        Password password = new Password(member, command.password());
        passwordRepository.insert(password);

        // TODO - 04 : 고의로 에러 발생 및 실행
        if (true)
            throw new IllegalArgumentException("Error Arguments");

        return;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
