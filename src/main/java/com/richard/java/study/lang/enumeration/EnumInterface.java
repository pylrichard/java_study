package com.richard.java.study.lang.enumeration;

/**
 * 见深入理解Java枚举类型
 * <p>
 * 10.png
 */
interface Mouth {
    void eat();
}

interface Leg {
    void run();
}

public enum EnumInterface implements Mouth, Leg {
    MOUTH,
    LEG,;

    @Override
    public void eat() {
        System.out.println("eat");
    }

    @Override
    public void run() {
        System.out.println("run");
    }
}