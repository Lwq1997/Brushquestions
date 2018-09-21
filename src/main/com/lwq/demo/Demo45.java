package main.com.lwq.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/18 15:17
 * @Version 1.0
 * @Describe
 */
/*
输入：1234 2
输出：34
 */
public class Demo45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long num = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(del(num,k));
        }
    }

    private static long del(long num, int k) {
        char[] char1 = String.valueOf(num).toCharArray();
        char[] char2 = String.valueOf(num).toCharArray();
        if(char1.length<k){
            return num;
        }
        StringBuilder sb = new StringBuilder();
        List list = new ArrayList();
        Arrays.sort(char1);
        for(int i = 0 ; i < k ; i++){
            for(int j = 0; j < char2.length;j++){
                if(char1[i]==char2[j]){
                    list.add(j);
                }
            }
        }
        for(int i = 0; i < char2.length;i++){
            if(!list.contains(i)){
                sb.append(char2[i]);
            }
        }
        return Long.parseLong(sb.toString());
    }
}
