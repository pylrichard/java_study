package com.richard.java.study.lang.enumeration;

/**
 * 见深入理解Java枚举类型
 * <p>
 * 9.png
 */
public enum EnumAbstractMethod {
    FIRST {
        @Override
        public String getInfo() {
            return "FIRST";
        }
    },
    SECOND {
        @Override
        public String getInfo() {
            return "SECOND";
        }
    };

    public abstract String getInfo();
}
