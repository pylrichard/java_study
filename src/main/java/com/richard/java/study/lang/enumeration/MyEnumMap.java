package com.richard.java.study.lang.enumeration;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * 见深入理解Java枚举类型
 * <p>
 * 13.png
 */
public class MyEnumMap {
    private static List<Clothes> clothes = Lists.newArrayList();

    static {
        clothes.add(new Clothes(1L, Color.BLUE));
        clothes.add(new Clothes(2L, Color.YELLOW));
        clothes.add(new Clothes(3L, Color.RED));
        clothes.add(new Clothes(4L, Color.GREEN));
        clothes.add(new Clothes(5L, Color.BLUE));
        clothes.add(new Clothes(6L, Color.RED));
    }

    public void countByHashMap() {
        Map<String, Integer> countMap = Maps.newHashMap();
        for (Clothes clothes : clothes) {
            String colorName = clothes.getColor().name();
            countMap.merge(colorName, 1, (oldValue, value) -> oldValue + 1);
        }
        System.out.println(countMap.toString());
    }

    public void countByEnumMap() {
        //EnumMap要求key为枚举，而且不能为null
        Map<Color, Integer> countMap = Maps.newEnumMap(Color.class);
        for (Clothes clothes : clothes) {
            Color color = clothes.getColor();
            countMap.merge(color, 1, (oldValue, value) -> oldValue + 1);
        }
        System.out.println(countMap.toString());
    }
}
