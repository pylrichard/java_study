package com.richard.java.study.lang.string.builder;

public class EmptyStringBuilder {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.toString().equals(""));
    }
}
