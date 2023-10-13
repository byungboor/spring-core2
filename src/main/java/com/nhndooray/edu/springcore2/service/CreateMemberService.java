package com.nhndooray.edu.springcore2.service;

import com.nhndooray.edu.springcore2.domain.Member;
import com.nhndooray.edu.springcore2.domain.Password;
import com.nhndooray.edu.springcore2.event.CreateMemberEvent;
import com.nhndooray.edu.springcore2.repository.MemberRepository;
import com.nhndooray.edu.springcore2.repository.PasswordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateMemberService {

    private final MemberRepository memberRepository;
    private final PasswordRepository passwordRepository;
    private final CreateMemberEventPublisher publisher;

    @Transactional
    public Member create(CreateMemberCommand command) {
        Member member = new Member(command.userCode());
        memberRepository.insert(member);

        Password password = new Password(member, command.password());
        passwordRepository.insert(password);

        // TODO - 04 : 주입받은 CreateMemberEventPublisher 스프링 빈의 publish 메서드를 사용하여 CreateMemberEvent 이벤트를 발송합니다.


        return member;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
