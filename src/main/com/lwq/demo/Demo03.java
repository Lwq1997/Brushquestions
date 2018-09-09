package main.com.lwq.demo;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/9 15:46
 * @Version 1.0
 * @Describe
 */
/*
给定一个字符串，找出最长的对称子串

例如：
输入：abbaad
输出：abba


 */
public class Demo03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            System.out.println(longestPalindrome(str));
        }
    }

    public static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1
                && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        String subS = s.substring(begin + 1, end);
        return subS;
    }

    public static String longestPalindrome(String s) {

        if (s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        int n = s.length();
        String longest = "";

        String str;
        for (int i=0; i<n-1; i++) {
            str = helper(s, i, i);
            if (str.length() > longest.length()){
                longest = str;
            }
            str = helper(s, i, i + 1);
            if (str.length() > longest.length()){
                longest = str;
            }
        }
        return longest;
    }
}
