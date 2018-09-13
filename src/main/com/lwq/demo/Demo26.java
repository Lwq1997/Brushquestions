package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/13 16:26
 * @Version 1.0
 * @Describe
 */
/*
小和问题
【1,3,4,2,5】
比1小的:没有
比3小的：1
比4小的：1,3
比2小的：1
比5小的：1，3,4,2
小和：1+1+3+1+1+3+4+2=16
 */
public class Demo26 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,5};
        System.out.println(method(arr));
        System.out.println(method2(arr));
    }

    private static int method2(int[] arr) {
        if(arr==null||arr.length<2){
            return 0;
        }
        return mergeSort(arr,0,arr.length-1);
    }

    private static int mergeSort(int[] arr, int L, int R) {
        if(L==R){
            return 0;
        }
        int mid = L+((R-L) >> 1);
        return mergeSort(arr,L,mid)
                +mergeSort(arr,mid+1,R)
                +merge(arr,L,mid,R);
    }

    private static int merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R-L+1];
        int p1 = L;
        int p2 = mid+1;
        int res = 0;
        int i = 0;
        while (p1<=mid&&p2<=R){
            res += arr[p1]<arr[p2]?arr[p1]*(R-p2+1):0;
            help[i++] = arr[p1]>arr[p2]?arr[p2++]:arr[p1++];

        }
        while (p1<=mid){
            help[i++] = arr[p1++];
        }
        while (p2<=R){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length;i++){
            arr[L+i] = help[i];
        }
        return res;
    }

    private static int method(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < i;j++){
                if(arr[j]<arr[i]){
                    sum+=arr[j];
                }
            }
        }
        return sum;
    }
}
