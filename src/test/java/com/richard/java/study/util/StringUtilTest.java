package com.richard.java.study.util;

import org.junit.Test;

public class StringUtilTest {
    @Test
    public void testFilterHtml2PlainText() {
        String srcText = "   id=666<script>alert()</script><style></style>        java    ";
        System.out.println(StringUtil.filterHtml2PlainText(srcText));
    }
}