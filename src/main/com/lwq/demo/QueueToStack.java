package main.com.lwq.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Lwq
 * @Date: 2018/9/14 14:50
 * @Version 1.0
 * @Describe
 */
/*
用两个队列形成栈
 */
public class QueueToStack {
    private Queue<Integer> queue;
    private Queue<Integer> help;

    public QueueToStack() {
        queue = new LinkedList<Integer>();
        help = new LinkedList<Integer>();
    }

    public void push(int pushInt){
        queue.add(pushInt);
    }

    public int pop(){
        if(queue.isEmpty()){
            throw new RuntimeException("Stack is empty!");
        }
        while (queue.size()>1){
            help.add(queue.poll());
        }
        int res = queue.poll();
        swap();
        return res;
    }

    public int peek(){
        if(queue.isEmpty()){
            throw new RuntimeException("Stack is empty!");
        }
        while (queue.size()!=1){
            help.add(queue.poll());
        }
        int res = queue.poll();
        help.add(res);
        swap();
        return res;
    }

    private void swap() {
        Queue<Integer> tmp = help;
        help = queue;
        queue = tmp;
    }
}
