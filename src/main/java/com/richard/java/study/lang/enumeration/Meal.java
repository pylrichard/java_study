package com.richard.java.study.lang.enumeration;

/**
 * 见深入理解Java枚举类型
 * <p>
 * 11.png
 */
public enum Meal {
    APPETIZER(Food.Appetizer.class),
    MAIN_COURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;

    Meal(Class<? extends Food> kind) {
        //通过Class对象获取枚举实例
        values = kind.getEnumConstants();
    }

    public Food[] getValues() {
        return values;
    }
}

interface Food {
    enum Appetizer implements Food {
        SALAD, SOUP;
    }

    enum MainCourse implements Food {
        BURRITO, LENTILS;
    }

    enum Dessert implements Food {
        BLACK_FOREST_CAKE, FRUIT;
    }

    enum Coffee implements Food {
        CAPPUCCINO, TEA;
    }
}
