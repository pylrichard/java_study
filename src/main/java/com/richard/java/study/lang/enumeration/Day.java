package com.richard.java.study.lang.enumeration;

/**
 * 见深入理解Java枚举类型
 * <p>
 * 7.png
 */
public enum Day {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    //要用分号结束
    SUNDAY("星期日");

    private String desc;

    /**
     * 私有构造函数，防止被外部调用
     */
    Day(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 见8.png，覆盖toString()省去getDesc()
     */
    @Override
    public String toString() {
        return desc;
    }
}
