package main.com.lwq.demo;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/10 15:56
 * @Version 1.0
 * @Describe
 */
/*
求一个数列中最大连续数字个数及起始数字，数列元素为整数，有序且不重复，部分数字连续。例如：{1, 3, 4, 6, 7, 8, 9, 11}的最大连续个数为4，起始数字为6。

输入
在一行中完成输入，多个数字之间以空格间隔。

输出
输出最大连接数字的个数和起始数字，格式为：[起始数字, 连续个数] 

样例输入
1 4 5 6 7 8 10 11 12 14 18
样例输出
[4, 5]
 */
public class Demo09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = null;
        nums = sc.nextLine().split(" ");
        int num[]=new int[nums.length];
        for(int i=0;i<num.length;i++) {
            num[i] = Integer.valueOf(nums[i]);
        }
        int start = num[0];
        int count = 1;
        int c = 1;
        for(int i = 0; i < nums.length-1 ;i++){
            if(num[i]==num[i+1]-1){
                    count++;
            }else {
               c = Math.max(count,c);
               count = 1;
            }
        }
        for(int i = 0; i < nums.length;i++){
            if(num[i]+c-1 == num[i+c-1]){
                start = num[i];
                break;
            }
        }
        System.out.println("["+start+", "+c+"]");
    }
}
