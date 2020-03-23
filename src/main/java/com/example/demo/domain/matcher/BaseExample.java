package com.example.demo.domain.matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-12-09 10:33
 */
public class BaseExample {
  private static Pattern pattern = Pattern.compile("_(\\w)");

  private static String underLineToCamel(String source) {
    Matcher matcher = pattern.matcher(source);
    StringBuffer sb = new StringBuffer();
    while (matcher.find()) {
      // matcher.group(1)-->(\\w) 匹配任意一个单词字符，等价于"[A-Za-z0-9_]"
      matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
    }
    matcher.appendTail(sb);
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(underLineToCamel("aaa_bbbb_ccc_dd"));
  }
}
