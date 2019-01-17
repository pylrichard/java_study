package com.richard.java.study.lang.integer;

import org.junit.Test;

public class BitOperationTest {
    @Test
    public void testBitOperation() {
        BitOperation bitOperation = new BitOperation(Integer.parseInt("1011", 2));
        for (BitType bitType : BitType.values()) {
            System.out.println(bitType.getDesc() + ":" + Integer.toBinaryString(bitOperation.getStatus(bitType)));
        }
        bitOperation.disableStatus(BitType.STATUS_1);
        bitOperation.disableStatus(BitType.STATUS_2);
        bitOperation.enableStatus(BitType.STATUS_3);
        bitOperation.disableStatus(BitType.STATUS_4);
        if (!bitOperation.isStatusEnabled(BitType.STATUS_1)) {
            System.out.println("关闭状态1");
        }
    }
}