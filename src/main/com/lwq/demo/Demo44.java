package main.com.lwq.demo;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: Lwq
 * @Date: 2018/9/18 15:05
 * @Version 1.0
 * @Describe
 */
/*
计算逆波兰表达式
 */
public class Demo44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            String[] strs = s.split(" ");

            System.out.println(count(strs));
        }
    }

    private static int count(String[] strs) {
        if(strs.length==0||strs==null){
            return 0;
        }
        if(strs.length==1){
            return Integer.parseInt(strs[0]);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < strs.length ; i++){
            String str = strs[i];
            if(str.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);
            }else if(str.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a*b);
            }else if(str.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a-b);
            }else if(str.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a/b);
            }else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}
