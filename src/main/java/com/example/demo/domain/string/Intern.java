package com.example.demo.domain.string;

/**
 * @program: demo
 * @description:
 * @author: wenky
 * @email: huwenqi@panda-fintech.com
 * @create: 2020-01-15 10:29
 */
public class Intern {
  public static void intern() {
    String a1 = "a";
    String a2 = new String("a");
    System.out.println(a1 == a2); // false
    String a3 = new String("a").intern();
    System.out.println(a1 == a3); // true

    String b1 = new String("b");
    b1.intern();
    String b2 = "b";
    System.out.println(b1 == b2); // false
  }

  public static void test1() {
    String a = "a"; // 在常量池中
    String b = "b"; // 在常量池中
    String c = "ab"; // 在常量池中
    String sum1 = a + b; // 在堆中
    String sum2 = "a" + "b"; // 在常量池中
    String sum3 = "a" + b;
    String d = new String("ab"); // 在堆中
    System.out.println(sum1 == c); // false
    System.out.println(sum2 == c); // true
    System.out.println(sum3 == c); // false
    System.out.println(c == d); // false
    System.out.println(c == d.intern()); // true
  }

  public static void main(String[] args) {
    //
    intern();
    test1();
  }
}
