package main.com.lwq.demo;

import java.lang.reflect.Array;

/**
 * @Author: Lwq
 * @Date: 2018/9/14 14:29
 * @Version 1.0
 * @Describe
 */
/*
数组实现栈
 */
public class ArrayStack {
    private Integer[] arr;
    private Integer size;

    public ArrayStack(int initSize){
        if(initSize<0) {
            throw new IllegalArgumentException("容量不能小于0");
        }
        arr = new Integer[initSize];
        size = initSize;
    }

    public Integer peek(){
        if(size==0){
            return null;
        }
        return arr[size-1];
    }

    public void push(int obj){
        if(size==arr.length){
            throw new ArrayIndexOutOfBoundsException("栈已经满了");
        }
        arr[size++] = obj;
    }

    public Integer pop(int obj){
        if(size==0){
            throw new ArrayIndexOutOfBoundsException("栈是空的");
        }
        return arr[--size];
    }
}
