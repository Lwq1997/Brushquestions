package main.com.lwq.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/12 19:40
 * @Version 1.0
 * @Describe
 */
/*
迅雷笔试题，算出n以下的所有勾股数组，然后看看每组勾股数的三个数是不是互质
 */
public class Demo20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<String> list = getGouGu(N);
        int count = 0;
        for(String str:list){
            String[] s = str.split(" ");
            int a = Integer.valueOf(s[0]);
            int b = Integer.valueOf(s[1]);
            int c = Integer.valueOf(s[2]);
            if(isHuZhi(a,b)&&isHuZhi(b,c)&&isHuZhi(a,c)){
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isHuZhi(int a, int b) {
        if(a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int c;
        while((c = a % b) != 0) {
            a = b;
            b = c;
        }
        return (b == 1);//b == 1 表示互质
    }

    private static List<String> getGouGu(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i <= n;i++){
            for(int j = i;j<=n;j++){
                for(int z = j+1;z<=n;z++){
                    if(i*i+j*j==z*z){
                        list.add(i+" "+j+" "+z);
                    }
                }
            }
        }
        return list;
    }
}
