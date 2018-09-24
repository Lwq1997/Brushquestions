package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/14 14:34
 * @Version 1.0
 * @Describe
 */
/*
数组实现队列
 */
public class ArrayQueue {
    private Integer[] arr;
    private Integer size;
    private Integer first;
    private Integer last;

    public ArrayQueue(int initSize){
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public Integer peek(){
        if(size==0){
            return null;
        }
        return arr[first];
    }

    public Integer poll(){
        if(size==0){
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        size--;
        int tmp = first;
        first = first == arr.length-1?0:first+1;
        return arr[tmp];
    }

    public void push(int obj){
        if(size==arr.length){
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        size++;
        arr[last] = obj;
        last = last==arr.length-1?0:last+1;
    }
}
