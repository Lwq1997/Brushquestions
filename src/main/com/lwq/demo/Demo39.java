package main.com.lwq.demo;

import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/15 20:57
 * @Version 1.0
 * @Describe
 */
public class Demo39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(addBinary(s1,s2));
    }

    private static String addBinary(String a, String b) {
        String result = "";
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        int sum = 0;
        while (aLen >= 0 || bLen >= 0) {
            if (aLen >= 0) {
                sum += Integer.parseInt(a.substring(aLen, aLen + 1));
                aLen--;
            }
            if (bLen >= 0) {
                sum += Integer.parseInt(b.substring(bLen, bLen + 1));
                bLen--;
            }
            if (sum == 2) {
                result = "0" + result;
                sum = 1;
            } else if (sum == 0 || sum == 1) {
                result = sum + "" + result;
                sum = 0;
            } else if (sum == 3) {
                result = "1" + result;
                sum = 1;
            }
        }
        if (sum == 1)
            result = "1" + result;
        return result;
    }
}
