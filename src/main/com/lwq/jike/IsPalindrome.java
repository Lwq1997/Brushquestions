package main.com.lwq.jike;

/**
 * @Author: Lwq
 * @Date: 2018/10/15 9:11
 * @Version 1.0
 * @Describe
 */
/*
判断一个字符串是不是回文串
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(IsPalindrome("abba"));
        System.out.println(IsPalindrome("abbba"));
    }
    public static boolean IsPalindrome(String s){
        int low=0;
        int high=s.length()-1;
        while(low<high){
            if(s.charAt(low)!=s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}
