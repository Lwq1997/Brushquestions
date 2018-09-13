package main.com.lwq.demo;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/13 20:42
 * @Version 1.0
 * @Describe
 */
/*
输入：hello xiao mi
输出：mi xiao hello
 */
public class Demo29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str1 = sc.nextLine();
            String[] str1s = str1.split(" ");
            for(int i =str1s.length-1 ; i > -1;i--){
                if(i==0){
                    System.out.print(str1s[i]);
                }else {
                    System.out.print(str1s[i]+" ");
                }
            }
        }
    }
}
