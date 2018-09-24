package main.com.lwq.demo;

import java.util.Stack;

/**
 * @Author: Lwq
 * @Date: 2018/9/24 12:31
 * @Version 1.0
 * @Describe
 */
/*
判断一个字符串是不是回文
 */
public class panduanHuiWen {
    public static void main(String[] args) {
        String s1 = "abba";
        String s2 = "abbc";
        String s3 = "abbba";
        String s4 = "abbbc";
        System.out.println(huiwen(s1.toCharArray()));
        System.out.println(huiwen(s2.toCharArray()));
        System.out.println(huiwen(s3.toCharArray()));
        System.out.println(huiwen(s4.toCharArray()));
    }

    private static boolean huiwen(char[] chars) {
        int start = 0;
        int end = chars.length-1;
        int mid = start+(end-start)>>1;
        Stack stack = new Stack();
        for(int i = 0; i <= mid ; i++){
            stack.push(chars[i]);
        }
        for(int i = (chars.length%2==0?mid+1:mid); i <= end ; i++){
            if(!stack.pop().equals(chars[i])){
                return false;
            }
        }
        return true;
    }


}
