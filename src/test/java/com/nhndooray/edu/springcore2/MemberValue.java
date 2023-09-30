package com.nhndooray.edu.springcore2;

import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

@Getter
@ToString
public class MemberValue {

    private Long id;
    private String name;

    public MemberValue(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
