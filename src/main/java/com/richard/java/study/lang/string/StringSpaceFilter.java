package com.richard.java.study.lang.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringSpaceFilter {
    public static void main(String[] args) {
        String originalStr = "richard is a cute boy";
        String[] splitArray = originalStr.split(" ");
        String combinedStr = Arrays.asList(splitArray).stream().collect(Collectors.joining());
        System.out.println(combinedStr);
    }
}
