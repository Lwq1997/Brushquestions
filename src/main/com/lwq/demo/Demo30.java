package main.com.lwq.demo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/13 20:46
 * @Version 1.0
 * @Describe
 */
/*
打印出一个字符串中第三次出现的字符
 */
public class Demo30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            HashMap<Character,Integer> map = new HashMap<>();
            for(char c:chars){
                if(map.containsKey(c)){
                    if(map.get(c)==2&&c!=' '){
                        System.out.println(c);
                        break;
                    }
                    map.put(c,map.get(c)+1);
                }else {
                    map.put(c,1);
                }
            }
        }
    }
}
