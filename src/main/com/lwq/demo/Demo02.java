package main.com.lwq.demo;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/6 10:56
 * @Version 1.0
 * @Describe 大数相乘
 */
public class Demo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String num1 = sc.next();
            String num2 = sc.next();
            System.out.println(multiply(num1, num2));
        }
    }
    public static String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int[] num = new int[length1+length2];
        for(int i=0;i<length1;i++) {
            int n1=num1.charAt(length1-1-i)-'0';
            //保存进位
            int jinwei=0;
            for(int j=0;j<length2;j++) {
                int n2=num2.charAt(length2-1-j)-'0';
                jinwei+=num[i+j]+n1*n2;
                num[i+j]=jinwei%10;
                jinwei/=10;
            }
            num[i+length2]=jinwei;
        }

        int i=length1+length2-1;
        while(i>0&&num[i]==0){
            i--;
        }
        StringBuilder result=new StringBuilder("");
        while(i>=0) {
            result.append(num[i--]);
        }
        return result.toString();
    }
}
