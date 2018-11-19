package com.richard.java.study.lang.enumeration;

/**
 * 见深入理解Java枚举类型
 * <p>
 * 12.png
 */
enum Color {
    GREEN,
    RED,
    BLUE
}

public class EnumSwitch {
    public static void printName(Color color) {
        switch (color) {
            //无需使用Color进行引用
            case BLUE:
                System.out.println("蓝色");
                break;
            case RED:
                System.out.println("红色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
        }
    }
}
