package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/21 13:02
 * @Version 1.0
 * @Describe
 */
/*
汉诺塔
 */
public class hannuota {
    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }

    private static void hanoi(int n) {
        if(n>0){
            func(n,"left","mid","right");
        }
    }

    private static void func(int N, String from, String help, String to) {
        if(N==1){
            System.out.println("move 1" + " from " + from + " to " + to);
        }else {
            func(N-1,from,to,help);
            System.out.println("move " + N + " from " + from + " to " + to);
            func(N-1,help,from,to);
        }
    }
}
