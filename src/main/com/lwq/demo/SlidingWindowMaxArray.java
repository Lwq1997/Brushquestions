package main.com.lwq.demo;

import java.util.LinkedList;

import static main.com.lwq.demo.bfprt.printArray;

/**
 * @Author: Lwq
 * @Date: 2018/9/22 16:33
 * @Version 1.0
 * @Describe
 */
public class SlidingWindowMaxArray {
    public static int[] getMaxWindow(int[] arr,int w){
        if(arr==null||w<1||arr.length<w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length-w+1];
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            while (!qmax.isEmpty()&&arr[qmax.peekLast()]<arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekFirst()==i-w){
                //窗口大小超过w
                qmax.pollFirst();
            }
            if(i >= w-1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5,6,2,5,9,6,3,0};
        printArray(getMaxWindow(arr,3));
    }
}
