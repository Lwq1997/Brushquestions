package main.com.lwq.demo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Lwq
 * @Date: 2018/9/21 11:49
 * @Version 1.0
 * @Describe
 */
/*
给定一个字符串数组，拼接起来，要求字典序最小
 */
public class LowestLexicography {
    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));
        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));
    }

    private static String lowestString(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        Arrays.sort(strs,new MyComparator());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.length ; i++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    private static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            return (a+b).compareTo(b+a);
        }
    }
}
