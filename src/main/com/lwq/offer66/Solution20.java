package main.com.lwq.offer66;

import java.util.Stack;

/**
 * @Author: Lwq
 * @Date: 2018/10/13 11:53
 * @Version 1.0
 * @Describe
 */
/*
定义栈的数据结构，
请在该类型中实现一个能够得到栈中所含最小元素的min函数
（时间复杂度应为O（1））。
 */
public class Solution20 {
    Stack<Integer> dataStack = new Stack();
    Stack<Integer> minStack = new Stack();
    public void push(int node) {
        dataStack.push(node);
        if(minStack.isEmpty()||node<minStack.peek()){
            minStack.push(node);
        }else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
