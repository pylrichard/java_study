package com.richard.java.study.lang.integer;

import lombok.AllArgsConstructor;

/**
 * 使用Integer表示状态集合，节省存储空间
 */
@AllArgsConstructor
public class BitOperation {
    private Integer statusSet;

    public Boolean isStatusEnabled(BitType bitType) {
        Integer status = getStatus(bitType);
        return bitType.getCode().equals(status);
    }

    public Integer getStatus(BitType bitType) {
        return statusSet & bitType.getCode();
    }

    public void enableStatus(BitType bitType) {
        statusSet |= bitType.getCode();
        System.out.println(Integer.toBinaryString(statusSet));
    }

    public void disableStatus(BitType bitType) {
        statusSet &= ~bitType.getCode();
        System.out.println(Integer.toBinaryString(statusSet));
    }
}
