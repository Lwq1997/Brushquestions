package main.com.lwq.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: Lwq
 * @Date: 2018/9/24 12:47
 * @Version 1.0
 * @Describe
 */
/*
扑克牌游戏，就是接火车
 */
public class pukepai {
    public static void main(String[] args) {
        int[] a = {2,4,1,2,5,6};
        int[] b = {3,1,3,5,6,4};
        int[] book = new int[10];

        Queue<Integer> queue1 = new LinkedList();
        Queue<Integer> queue2 = new LinkedList();
        Stack<Integer> stack = new Stack<>();
        int flag = 0;

        for(int i = 0; i<6 ; i++ ){
            queue1.add(a[i]);
            queue2.add(b[i]);
        }

        while (!queue1.isEmpty()&&!queue2.isEmpty()){
            int t = queue1.poll();
            if(book[t]==0){  //表示桌上没有这张牌
                stack.push(t);
                book[t] = 1;
            }else {
                //表示桌上有牌
                queue1.add(t);
                while (stack.peek()!=t){
                    book[stack.peek()] = 0;
                    queue1.add(stack.pop());
                }
                queue1.add(stack.pop());
                book[t] = 0;
            }
            if(queue1.isEmpty()){
                break;
            }

            int q = queue2.poll();
            if(book[q]==0){  //表示桌上没有这张牌
                stack.push(q);
                book[q] = 1;
            }else {
                //表示桌上有牌
                queue2.add(q);
                while (stack.peek()!=q){
                    book[stack.peek()] = 0;
                    queue2.add(stack.pop());
                }
                queue2.add(stack.pop());
                book[q] = 0;
            }
            if(queue2.isEmpty()){
                break;
            }
        }

        if(queue1.isEmpty()){
            System.out.println("队列2赢了");
            System.out.print("队列2的牌是：");
            while (!queue2.isEmpty()){
                System.out.print(queue2.poll()+" ");
            }
            System.out.println();
            System.out.print("桌上的牌：");
            while (!stack.isEmpty()){
                System.out.print(stack.pop()+" ");
            }
        }else {
            System.out.println("队列1赢了");
            System.out.print("队列1的牌是：");
            while (!queue1.isEmpty()){
                System.out.print(queue1.poll()+" ");
            }
            System.out.println();
            System.out.print("桌上的牌：");
            while (!stack.isEmpty()){
                System.out.print(stack.pop()+" ");
            }
        }
    }
}
