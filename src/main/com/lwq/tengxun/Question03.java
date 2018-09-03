package main.com.lwq.tengxun;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/3 14:02
 * @Version 1.0
 * @Describe
 */
/*
给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
输出需要删除的字符个数。

输入描述:
输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.

输出描述:
对于每组数据，输出一个整数，代表最少需要删除的字符个数。

输入例子1:
abcda
google

输出例子1:
2
2
 */
/*
求原字符串和其反串的最大公共子串的长度，然后用原字符串的长度减去这个最大公共子串的长度就得到了最小编辑长度。
（注：最大公共子串并不一定要连续的，只要保证出现次序一致即可看作公共子串）
 　　
对于1≤i≤N，1≤j≤M，有公式一
若ai=bj，则LCS(i,j)=LCS(i-1,j-1)+1
若ai≠bj，则LCS(i,j)=Max(LCS(i-1,j-1),LCS(i-1,j),LCS(i,j-1))
 */
public class Question03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.next();
            String s2 = new StringBuilder(s1).reverse().toString();
            int[][] dp = new int[s1.length()+1][s2.length()+1];
            for(int i = 1; i <dp.length ; i++){
                for(int j = 1; j <dp[0].length;j++){
                    dp[i][j] = s1.charAt(i-1)==s2.charAt(j-1)?dp[i-1][j-1]+1:Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
            System.out.println(s1.length()-dp[s1.length()][s2.length()]);
        }
    }
}
