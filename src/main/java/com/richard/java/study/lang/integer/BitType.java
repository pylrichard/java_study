package com.richard.java.study.lang.integer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BitType {
    STATUS_1(1, "状态1"),
    STATUS_2(2, "状态2"),
    STATUS_3(4, "状态3"),
    STATUS_4(8, "状态4");

    private Integer code;

    private String desc;
}
