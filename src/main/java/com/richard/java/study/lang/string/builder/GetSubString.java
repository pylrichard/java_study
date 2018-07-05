package com.richard.java.study.lang.string.builder;

public class GetSubString {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("123,");
        stringBuilder.append("456,");
        String str = stringBuilder.toString();
        //避免str长度为0时越界
        if (str.length() > 0) {
            System.out.println(str.substring(0, str.length() - 1));
        }
    }
}
