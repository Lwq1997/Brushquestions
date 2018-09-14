package main.com.lwq.demo;

import java.util.Stack;

/**
 * @Author: Lwq
 * @Date: 2018/9/14 14:42
 * @Version 1.0
 * @Describe
 */
/*
往一个栈中放入数据，要求随时可以得到栈中的最小值
 */
public class Demo32 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Demo32() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public int getmin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return this.stackMin.peek();
    }

    public void push(int newNum){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if(newNum<=this.getmin()){
            this.stackMin.push(newNum);
        }else {
            this.stackMin.push(getmin());
        }
        this.stackData.push(newNum);
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        int value = this.stackData.pop();
        if(value==this.getmin()){
            this.stackMin.pop();
        }
        return value;
    }
}
