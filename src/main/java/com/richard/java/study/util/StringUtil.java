package com.richard.java.study.util;

import afu.org.checkerframework.checker.igj.qual.I;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

    public static Integer getSameElementCount(String content) {
        Map<String, Integer> countMap = Maps.newHashMap();
        Integer totalCount = 0;
        Integer elementCount = 0;
        for (int i = 0; i < content.length(); i++) {
            String element = String.valueOf(content.charAt(i));
            if (!countMap.containsKey(element)) {
                countMap.put(element, 1);
            } else {
                elementCount = countMap.get(element);
                countMap.put(element, elementCount + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            elementCount = entry.getValue();
            totalCount += (elementCount > 1 ? elementCount : 0);
        }

        return totalCount;
    }

    public static Integer getSameContinuousElementCount(String content, String regex) {
        Map<String, List<Integer>> indexMap = Maps.newHashMap();
        Integer count = 0;
        for (int i = 0; i < content.length(); i++) {
            String element = String.valueOf(content.charAt(i));
            if (!indexMap.containsKey(element)) {
                List<Integer> indexList = Lists.newArrayList();
                indexList.add(i);
                indexMap.put(element, indexList);
            } else {
                List<Integer> indexList = indexMap.get(element);
                indexList.add(i);
            }
        }
        for (Map.Entry<String, List<Integer>> entry : indexMap.entrySet()) {
            String element = entry.getKey();
            List<Integer> indexList = entry.getValue();
            HashSet<Integer> indexSet = Sets.newHashSet();
            Integer size = indexList.size();
            for (int i = 0; i < size; i++) {
                if (i == (size - 1)) {
                    break;
                }
                Integer current = indexList.get(i);
                Integer next = indexList.get(i + 1);
                Matcher matcher = getMatcher(regex, element);
                if (matcher.matches()) {
                    if ((next - current) == 1) {
                        indexSet.add(i);
                        indexSet.add(i + 1);
                    }
                }
            }
            count += indexSet.size();
        }

        return count;
    }

    public static Boolean hasDigit(String content) {
        /*
            匹配次数
            *       0次或多次
            +       1次或多次
            ?       0次或者1次
            {n}     n次
            {n, m}  n到m次
         */
        Matcher matcher = getMatcher(".*\\d+.*", content);

        return matcher.matches() ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Boolean isDigit(String content) {
        Matcher matcher = getMatcher("[0-9]{1,}", content);

        return matcher.matches();
    }

    public static Boolean isNumeric(String content) {
        for (int i = 0; i < content.length(); i++) {
            if (!Character.isDigit(content.charAt(i))) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    public static Integer getSymbolCount(String content) {
        /*
            /d  [0-9]
            /D  [^0-9]
            /w  [a-z0-9]
            /W  [^a-z0-9]
         */
        return getElementCount("[^a-zA-Z0-9]", content);
    }

    public static Integer getCharCount(String content) {
        return getElementCount("[a-zA-Z]", content);
    }

    public static Integer getNumCount(String content) {
        /*
            "123"被"\\d"匹配成3个数字，被"\\d+"匹配成1个数字
         */
        return getElementCount("\\d", content);
    }

    private static Integer getElementCount(String regex, String content) {
        Matcher matcher = getMatcher(regex, content);
        Integer count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }

    private static Matcher getMatcher(String regex, String content) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(content);
    }
}