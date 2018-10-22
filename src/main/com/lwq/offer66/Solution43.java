package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/17 23:20
 * @Version 1.0
 * @Describe
 */

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */
public class Solution43 {
    /**
     * 这道题考的核心是应聘者是不是可以灵活利用字符串翻转。假设字符串abcdef，n=3，
     * 设X=abc，Y=def，所以字符串可以表示成XY，如题干，问如何求得YX。
     * 假设X的翻转为XT，XT=cba，同理YT=fed，那么YX=(XTYT)T，三次翻转后可得结果。
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString03(String str,int n) {
        char[] chars = str.toCharArray();
        if(chars.length < n) return "";
        reverse(chars, 0, n-1);
        reverse(chars, n, chars.length-1);
        reverse(chars, 0, chars.length-1);
        StringBuilder sb = new StringBuilder(chars.length);
        for(char c:chars){
            sb.append(c);
        }
        return sb.toString();
    }

    public void reverse(char[] chars,int low,int high){
        char temp;
        while(low<high){
            temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }

    public String LeftRotateString02(String str,int n) {
        int len = str.length();
        if(len==0){
            return "";
        }
        String s1 = str.substring(0, n);
        String s2 = str.substring(n,str.length());
        return s2 + s1;
    }

    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if(len==0){
            return "";
        }
        n = n%len;
        str+=str;
        return str.substring(n,len+n);
    }

}
