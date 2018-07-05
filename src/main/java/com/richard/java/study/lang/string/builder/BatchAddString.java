package com.richard.java.study.lang.string.builder;

import com.google.common.collect.Lists;

import java.util.List;

public class BatchAddString {
    private static Integer SLICE_NUM = 100;

    public static void main(String[] args) {
        List<Integer> integerList = Lists.newArrayList();
        for (Integer i = 1; i < 498; i++) {
            integerList.add(i);
        }
        Integer listSize = integerList.size();
        StringBuilder builder = null;
        if (listSize > SLICE_NUM) {
            Integer count = listSize / SLICE_NUM;
            Integer remainder = listSize % SLICE_NUM;
            for (int i = 0; i < count; i++) {
                builder = new StringBuilder();
                for (int j = i * SLICE_NUM; j < (i + 1) * SLICE_NUM; j++) {
                    Integer num = integerList.get(j);
                    builder.append(num.toString() + ",");
                }
                printStringBuilder(builder);
            }
            builder = new StringBuilder();
            for (int i = 0; i < remainder; i++) {
                Integer num = integerList.get(SLICE_NUM * count + i);
                builder.append(num.toString() + ",");
            }
            printStringBuilder(builder);
        } else {
            builder = new StringBuilder();
            for (Integer num : integerList) {
                builder.append(num.toString() + ",");
            }
            printStringBuilder(builder);
        }
    }

    private static void printStringBuilder(StringBuilder builder) {
        String str = builder.toString();
        str = str.substring(0, str.length() - 1);
        System.out.println(str);
        System.out.println();
    }
}
