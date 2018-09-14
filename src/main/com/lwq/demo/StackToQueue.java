package main.com.lwq.demo;

import java.util.Stack;

/**
 * @Author: Lwq
 * @Date: 2018/9/14 14:50
 * @Version 1.0
 * @Describe
 */
/*
用两个栈形成队列
 */
public class StackToQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;
    public StackToQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }
    public void push(int obj){
        this.stackPush.push(obj);
    }

    public int poll(){
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        }else if(stackPop.empty()){     //pop有东西，push不能倒
            while (!stackPush.empty()){   //一次倒完
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }
}
