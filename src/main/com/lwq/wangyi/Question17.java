package main.com.lwq.wangyi;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/4 16:06
 * @Version 1.0
 * @Describe
 */
/*
小易有一些彩色的砖块。每种颜色由一个大写字母表示。各个颜色砖块看起来都完全一样。现在有一个给定的字符串s,s中每个字符代表小易的某个砖块的颜色。小易想把他所有的砖块排成一行。如果最多存在一对不同颜色的相邻砖块,那么这行砖块就很漂亮的。请你帮助小易计算有多少种方式将他所有砖块排成漂亮的一行。(如果两种方式所对应的砖块颜色序列是相同的,那么认为这两种方式是一样的。)
例如: s = "ABAB",那么小易有六种排列的结果:
"AABB","ABAB","ABBA","BAAB","BABA","BBAA"
其中只有"AABB"和"BBAA"满足最多只有一对不同颜色的相邻砖块。

输入描述:
输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s中的每一个字符都为一个大写字母(A到Z)。

输出描述:
输出一个整数,表示小易可以有多少种方式。

输入例子1:
ABAB

输出例子1:
2
 */
/*
思想就是看字符串里有几种字符，
    超过两种就不可能只有一对相邻的不同字符(不满足题意)，
    有两种字符就是两种正确的排列，
    有一种字符自然就是一种正确的排列。
 */
public class Question17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
            HashSet<Character> set = new HashSet();
            for(int i = 0; i < s.length();i++){
                set.add(s.charAt(i));
            }
            if(set.size()>2){
                System.out.println(0);
            }else if(set.size()==2){
                System.out.println(2);
            }else if(set.size()==1){
                System.out.println(1);
            }
        }

    }
}
