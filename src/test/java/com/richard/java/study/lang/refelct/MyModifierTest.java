package com.richard.java.study.lang.refelct;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Modifier通过位运算判断类、变量、方法的修饰符
 * 比如isAbstract()判断是否有abstract修饰符
 * class.getModifiers()返回的整型，看是否包含如
 * public static final int PUBLIC = 0x00000001的位
 * <p>
 * 可在动态加载过程中使用反射对某些类进行过滤
 */
public class MyModifierTest {
    @Test
    public void testMyModifier() {
        Method[] methods = MyModifier.class.getMethods();
        System.out.println(methods[0].getName());
        System.out.println(Modifier.isAbstract(methods[0].getModifiers()));
    }
}