package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/13 0:00
 * @Version 1.0
 * @Describe
 */
/*
归并排序
 */
public class Demo23 {
    public static void main(String[] args) {
        int[] arr = new int[]{8,9,3,3,2,1,4,5,2,5};
        sortProcess(arr,0,arr.length-1);
        for(int i = 0; i < arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void sortProcess(int[] arr, int L, int R) {
        if(L==R){
            return;
        }
        int mid = L+((R-L)>>1);
        sortProcess(arr,L,mid);
        sortProcess(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = mid+1;
        while (p1<=mid&&p2<=R){
            help[i++] = arr[p1]>arr[p2]?arr[p2++]:arr[p1++];
        }
        while (p1<=mid){
            help[i++] = arr[p1++];
        }
        while (p2<=R){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[L+i] = help[i];
        }
    }
}
