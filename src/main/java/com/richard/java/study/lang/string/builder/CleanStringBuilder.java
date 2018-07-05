package com.richard.java.study.lang.string.builder;

public class CleanStringBuilder {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            builder = new StringBuilder();
            builder.append("aa");
            builder.append("bb");
            builder.append("cc");
            builder.append("dd");
            builder.append("ee");
        }
        System.out.println("new 耗时：" + (System.currentTimeMillis() - time));
        for (int i = 0; i < 10000000; i++) {
            builder.delete(0, builder.length());
            builder.append("a");
            builder.append("b");
            builder.append("c");
            builder.append("d");
            builder.append("e");
        }
        System.out.println("delete 耗时：" + (System.currentTimeMillis() - time));
        for (int i = 0; i < 10000000; i++) {
            builder.setLength(0);
            builder.append("1a");
            builder.append("1b");
            builder.append("1c");
            builder.append("1d");
            builder.append("1e");
        }
        System.out.println("setLength = 0 耗时：" + (System.currentTimeMillis() - time));
    }
}
