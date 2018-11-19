package com.richard.java.study.lang.enumeration;

import org.junit.Test;

import java.util.Arrays;

/**
 * 见深入理解Java枚举类型
 */
public class EnumTest {
    /*
        1.png
     */
    @Test
    public void testDay1() {
        //见1.png的$VALUES[]
        Day[] days = new Day[]{
                Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY,
                Day.FRIDAY, Day.SATURDAY, Day.SUNDAY
        };

        for (int i = 0; i < days.length; i++) {
            System.out.println("day[" + i + "].ordinal():" + days[i].ordinal());
        }

        System.out.println("days[0].compareTo(days[1]):" + days[0].compareTo(days[1]));
        System.out.println("days[0].compareTo(days[2]):" + days[0].compareTo(days[2]));

        Class<?> clazz = days[0].getDeclaringClass();
        System.out.println("clazz:" + clazz);

        System.out.println("days[0].name():" + days[0].name());

        System.out.println("days[0].toString():" + days[0].toString());

        System.out.println(Enum.valueOf(Day.class, days[0].name()));
        System.out.println(Day.valueOf(Day.class, days[0].name()));
    }

    /*
        5.png
     */
    @Test
    public void testDay2() {
        Day[] days = Day.values();
        System.out.println(Arrays.toString(days));
        Day day = Day.valueOf("MONDAY");
        System.out.println(day);
        Enum enumeration = Day.MONDAY;
        System.out.println(enumeration.name());
        //无法调用，Enum类中并没有values()
        //enumeration.values();
    }

    /*
        6.png
     */
    @Test
    public void testDay3() {
        Enum enumeration = Day.MONDAY;
        Class<?> clazz = enumeration.getDeclaringClass();
        if (clazz.isEnum()) {
            Day[] days = (Day[]) clazz.getEnumConstants();
            System.out.println(Arrays.toString(days));
        }
    }

    @Test
    public void testEnumAbstractMethod() {
        System.out.println(EnumAbstractMethod.FIRST.getInfo());
        System.out.println(EnumAbstractMethod.SECOND.getInfo());
    }

    @Test
    public void testMeal() {
        Food[] foods = Meal.APPETIZER.getValues();
        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i]);
        }
    }

    @Test
    public void testEnumSwitch() {
        EnumSwitch.printName(Color.BLUE);
        EnumSwitch.printName(Color.RED);
        EnumSwitch.printName(Color.GREEN);
    }
}