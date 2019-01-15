package com.richard.java.study.util;

import org.junit.Test;

public class StringUtilTest {
    private static final String CONTENT = "&!@#A4b5cd123";
    @Test
    public void testFilterHtml2PlainText() {
        String srcText = "   id=666<script>alert()</script><style></style>        java    ";
        System.out.println(StringUtil.filterHtml2PlainText(srcText));
    }

    @Test
    public void testHasDigit() {
        System.out.println(StringUtil.hasDigit(CONTENT));
    }

    @Test
    public void testIsNumeric() {
        System.out.println(StringUtil.isNumeric(CONTENT));
    }

    @Test
    public void testIsDigit() {
        System.out.println(StringUtil.isDigit(CONTENT));
    }

    @Test
    public void testGetSymbolCount() {
        System.out.println(StringUtil.getSymbolCount(CONTENT));
    }

    @Test
    public void testGetNumCount() {
        System.out.println(StringUtil.getNumCount(CONTENT));
    }

    @Test
    public void testGetCharCount() {
        System.out.println(StringUtil.getCharCount(CONTENT));
    }

    @Test
    public void testGetSameContinuousElementCount() {
        System.out.println(StringUtil.getSameContinuousElementCount("aaa1111bc22dD3EE", "[0-9a-zA-Z]"));
    }

    @Test
    public void testGetSameElementCount() {
        System.out.println(StringUtil.getSameElementCount("aa11bc22dD3EE"));
    }
}