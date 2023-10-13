package com.nhndooray.edu.springcore2.event;

import com.nhndooray.edu.springcore2.domain.Member;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.Assert;

@ToString
@Getter
public class CreateMemberEvent {

    private Long id;
    private String userCode;

    // TODO - 01 : 이벤트 객체는 불변 클래스입니다. 이벤트 객체를 수정하여 중간에 데이터가 오염되면 곤란합니다.
    public CreateMemberEvent(Long id, String userCode) {
        Assert.notNull(id, "id can't be null");
        Assert.hasLength(userCode, "userCode can't be empty");

        this.id = id;
        this.userCode = userCode;
    }

    public static CreateMemberEvent of(Member member) {
        Assert.notNull(member, "member can't be null");
        return new CreateMemberEvent(member.getId(), member.getUserCode());
    }
}
