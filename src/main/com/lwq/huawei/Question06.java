package main.com.lwq.huawei;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/1 13:49
 * @Version 1.0
 * @Describe
 */
/*
写出一个程序，接受一个十六进制的数值字符串，
输出该数值的十进制字符串。（多组同时输入 ）

输入描述:
输入一个十六进制的数值字符串。

输出描述:
输出该数值的十进制字符串。

输入例子1:
0xA

输出例子1:
10
 */
public class Question06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            StringBuilder sb = new StringBuilder();
            sb.append(sc.next());
            String str = sb.reverse().substring(0,sb.length()-2);
            char[] chars = str.toCharArray();
            int sum = 0;
            for(int i = 0; i < chars.length; i++){
                if(chars[i]>='A'&&chars[i]<='F'){
                    sum+=(Integer.valueOf(chars[i]-55))*Math.pow(16,i);
                }else {
                    sum+=(Integer.valueOf(chars[i]-48))*Math.pow(16,i);
                }
            }
            System.out.println(sum);
        }
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            String s = sc.next().substring(2);
//            System.out.println(Integer.parseInt(s,16));
//        }
//    }
}
