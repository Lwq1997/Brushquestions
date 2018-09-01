package main.com.lwq.wangyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: Lwq
 * @Date: 2018/9/1 15:54
 * @Version 1.0
 * @Describe
 */
/*
一个合法的括号匹配序列被定义为:
1. 空串""是合法的括号序列
2. 如果"X"和"Y"是合法的序列,那么"XY"也是一个合法的括号序列
3. 如果"X"是一个合法的序列,那么"(X)"也是一个合法的括号序列
4. 每个合法的括号序列都可以由上面的规则生成
例如"", "()", "()()()", "(()())", "(((()))"都是合法的。
从一个字符串S中移除零个或者多个字符得到的序列称为S的子序列。
例如"abcde"的子序列有"abe","","abcde"等。
定义LCS(S,T)为字符串S和字符串T最长公共子序列的长度,即一个最长的序列W既是S的子序列也是T的子序列的长度。
小易给出一个合法的括号匹配序列s,小易希望你能找出具有以下特征的括号序列t:
1、t跟s不同,但是长度相同
2、t也是一个合法的括号匹配序列
3、LCS(s, t)是满足上述两个条件的t中最大的
因为这样的t可能存在多个,小易需要你计算出满足条件的t有多少个。

如样例所示: s = "(())()",跟字符串s长度相同的合法括号匹配序列有:
"()(())", "((()))", "()()()", "(()())",其中LCS( "(())()", "()(())" )为4,其他三个都为5,所以输出3.
输入描述:
输入包括字符串s(4 ≤ |s| ≤ 50,|s|表示字符串长度),保证s是一个合法的括号匹配序列。


输出描述:
输出一个正整数,满足条件的t的个数。

输入例子1:
(())()

输出例子1:
3
 */
public class Question06 {
    private static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        getSequence(str);
        System.out.println(set.size()-1);
        sc.close();
    }

    //两次循环，把每个s的拿出来(第一层)，替换到所有位置上（第二层）
    private static void getSequence(String str) {
        for(int i = 0; i <str.length();i++){
            StringBuilder sb = new StringBuilder(str);
            char c = str.charAt(i);
            sb.deleteCharAt(i);
            for(int j = 0; j < str.length();j++){
                sb.insert(j,c);
                if(isLegal(sb.toString())){
                    set.add(sb.toString());
                }
                sb.deleteCharAt(j);
            }
        }
    }

    private static boolean isLegal(String s) {
        int left = s.length()/2;
        int right = s.length()/2;
        for(int i = 0; i <s.length();i++){
            if(s.charAt(i)=='('){
                left--;
            }else {
                right--;
            }
            if(right<left){
                return false;
            }
        }
        return true;
    }
}
