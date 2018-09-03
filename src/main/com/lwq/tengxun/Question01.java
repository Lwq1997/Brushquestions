package main.com.lwq.tengxun;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/3 14:02
 * @Version 1.0
 * @Describe
 */
/*
小Q最近遇到了一个难题：把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
你能帮帮小Q吗？

输入描述:
输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.

输出描述:
对于每组数据，输出移位后的字符串。

输入例子1:
AkleBiCeilD

输出例子1:
kleieilABCD
 */
public class Question01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.next();
            System.out.println(s1.replaceAll("[A-Z]","")+s1.replaceAll("[a-z]",""));
        }
    }
}
