package main.com.lwq.demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: Lwq
 * @Date: 2018/9/10 12:06
 * @Version 1.0
 * @Describe
 */
/*
不使用hashset完成去重和排序
 */
public class Demo08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = sc.nextInt();
        }
        quickSort(arr,0,n-1);
//        List<Integer> list =  Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n;i++){
            if(!list.contains(arr[i])){
                list.add(arr[i]);
            }
        }
        list.forEach(i -> System.out.print(i+" ") );
    }

    private static void quickSort(int[] arr, int left,int right) {
        if(left<right){
            int[] p = partition(arr,left,right);
            quickSort(arr,left,p[0]-1);
            quickSort(arr,p[1]+1,right);
        }
    }

    private static int[] partition(int[] arr, int left, int right) {
        int less = left-1;
        int more = right;
        int index = left;
        while (index<more){
            if(arr[index]<arr[right]){
                swap(arr,++less,index++);
            }else if(arr[index]>arr[right]){
                swap(arr,--more,index);
            }else {
                index++;
            }
        }
        swap(arr,right,more);
        return new int[]{less+1,more};
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
