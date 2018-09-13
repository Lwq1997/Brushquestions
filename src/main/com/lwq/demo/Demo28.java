package main.com.lwq.demo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Lwq
 * @Date: 2018/9/13 20:18
 * @Version 1.0
 * @Describe
 */
/*

 */
/*
5021
502104 198803
5021041988033084
502104198803308324

 */
public class Demo28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            String str = replaceBlank(s);
            if(str.length()<7){
                System.out.println(str);
            }
            if(str.length()>6&&str.length()<15){
                String str1 = str.substring(0,6);
                String str2 = str.substring(6,str.length());
                System.out.println(str1+" "+str2);
            }
            if(str.length()>14&&str.length()<19){
                String str1 = str.substring(0,6);
                String str2 = str.substring(6,14);
                String str3 = str.substring(14,str.length());
                System.out.println(str1+" "+str2+" "+str3);
            }
        }

    }
    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
