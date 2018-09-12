package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/12 18:41
 * @Version 1.0
 * @Describe
 */
/*
堆排序
 */
public class Demo19 {
    public static void main(String[] args) {
        int[] arr = new int[]{8,85,56,25,6,9,3,5,5,10,4,5,9,6,0,1};
        for(int i = 0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        int size = arr.length;
        swap(arr,0,--size);
        while (size>0){
            heapify(arr,0,size);
            swap(arr,0,--size);
        }
        for(int i = 0; i <arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void heapify(int[] arr, int index, int size) {
        int left = index*2+1;
        while (left<size){
            int largest = left+1<size && arr[left+1]>arr[left]?left+1:left;
            largest = arr[index]>arr[largest]?index:largest;
            if(index==largest){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = largest*2+1;
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    private static void swap(int[] arr, int index, int indey) {
        int temp = arr[index];
        arr[index] = arr[indey];
        arr[indey] = temp;
    }
}
