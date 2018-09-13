package main.com.lwq.demo;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @Author: Lwq
 * @Date: 2018/9/13 14:20
 * @Version 1.0
 * @Describe
 */
public class Demo24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            System.out.println(isIpv4(str));
        }
    }

    private static boolean isIpv4(String str) {
        if(!Pattern.matches("(((\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))\\.){3}((\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))", str)){
            return false;
        }else {
            return true;
        }

    }
}
