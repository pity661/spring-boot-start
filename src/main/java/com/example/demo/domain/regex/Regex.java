package com.example.demo.domain.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-24 15:01
 */
public class Regex {
    /**
     * 将字符串中所有非数字的字符移除
     *
     * @param str
     * @return
     */
    public static String replaceAllDisNum(String str) {
        return null == str ? null : str.replaceAll("[^\\d]", "");
    }

    /**
     * 截取指定区间内的字符串
     *
     * @param str
     * @return
     */
    public static String splitAppointInterval(String str) {
        // .*? 懒惰匹配，匹配最短的
        // .* 贪婪匹配匹配最长的
        String regex = "(.*aaa)(.*?)(bbb)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while (m.find()) {
            return m.group(2);
        }
        return null;
    }

    /**
     * 判断字符串是否满足指定正则表达式规则
     *
     * @param str
     * @param regex
     * @return
     */
    public static boolean matches(String str, String regex) {
        return null == str ? false : str.matches(regex);
    }
}
