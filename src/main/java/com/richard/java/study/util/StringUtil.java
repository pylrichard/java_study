package com.richard.java.study.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    /**
     * 过滤HTML标签能防止XSS攻击
     */
    public static String filterHtml2PlainText(String srcText) {
        String htmlText = srcText.trim();
        Pattern scriptPattern;
        Matcher scriptMatcher;
        Pattern stylePattern;
        Matcher styleMatcher;
        Pattern htmlPattern;
        Matcher htmlMatcher;
        Pattern spacePattern;
        Matcher spaceMatcher;
        Pattern escapePattern;
        Matcher escapeMatcher;

        //script标签正则表达式或<script[^>]*?>[\\s\\S]*?<\\/script>
        String scriptRegEx = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
        //style标签正则表达式或<style[^>]*?>[\\s\\S]*?<\\/style>
        String styleRegEx = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
        //HTML标签正则表达式
        String htmlRegEx = "<[^>]+>";
        //空格回车换行符正则表达式
        String spaceRegEx = "\\s*|\t|\r|\n";
        //转义字符正则表达式
        String escapeRegEx = "&.{2,6}?;";

        //过滤script标签
        scriptPattern = Pattern.compile(scriptRegEx, Pattern.CASE_INSENSITIVE);
        scriptMatcher = scriptPattern.matcher(htmlText);
        //返回值赋给htmlText，进行下一次过滤
        htmlText = scriptMatcher.replaceAll("");

        //过滤style标签
        stylePattern = Pattern.compile(styleRegEx, Pattern.CASE_INSENSITIVE);
        styleMatcher = stylePattern.matcher(htmlText);
        htmlText = styleMatcher.replaceAll("");

        //过滤HTML标签
        htmlPattern = Pattern.compile(htmlRegEx, Pattern.CASE_INSENSITIVE);
        htmlMatcher = htmlPattern.matcher(htmlText);
        htmlText = htmlMatcher.replaceAll("");

        //过滤空格回车标签
        spacePattern = Pattern.compile(spaceRegEx, Pattern.CASE_INSENSITIVE);
        spaceMatcher = spacePattern.matcher(htmlText);
        htmlText = spaceMatcher.replaceAll("");

        //过滤转义字符
        escapePattern = Pattern.compile(escapeRegEx, Pattern.CASE_INSENSITIVE);
        escapeMatcher = escapePattern.matcher(htmlText);
        String plainText = escapeMatcher.replaceAll("");

        return plainText;
    }
}