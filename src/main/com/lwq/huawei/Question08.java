package main.com.lwq.huawei;

import javax.security.sasl.SaslClient;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/8 20:08
 * @Version 1.0
 * @Describe
 */
/*
输入一个字符串，求出该字符串包含的字符集合

输入描述:
每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。

输出描述:
每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。

输入例子1:
abcqweracb

输出例子1:
abcqwer
 */
public class Question08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            HashSet<Character> set = new HashSet();
            StringBuilder sb = new StringBuilder();
            char[] chars = sc.next().toCharArray();
            for(int i = 0;i<chars.length;i++){
                if(set.add(chars[i]))
                    sb.append(chars[i]);
            }
            System.out.println(sb.toString());
        }
    }
}