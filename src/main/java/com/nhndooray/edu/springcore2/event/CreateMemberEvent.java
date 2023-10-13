package com.nhndooray.edu.springcore2.event;

import com.nhndooray.edu.springcore2.domain.Member;
import lombok.Getter;
import lombok.ToString;
import org.springframework.util.Assert;

@ToString
@Getter
// TODO - 01: extends AbstractEvent
public class CreateMemberEvent extends AbstractEvent {

    private Long id;
    private String userCode;

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
