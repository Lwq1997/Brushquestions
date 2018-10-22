package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/16 15:51
 * @Version 1.0
 * @Describe
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8
 * 这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Solution29 {
    public static void main(String[] args) {
        ArrayList list = GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4);
        for(int i = 0; i < list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input==null||input.length<k||k==0){
            return list;
        }
        for(int i = 0; i < k ; i++){
            heapInsert(input,i);
        }
        for(int i = k; i < input.length;i++){
            if(input[0]>input[i]){
                swap(input,0,i);
                heapify(input,0,k);
            }
        }
        for(int i = 0; i<k;i++){
            list.add(input[i]);
        }
        return list;
    }

    private static void heapify(int[] input, int index, int k) {
        int left = index*2+1;
        while (left<k){
            int largest = left+1<k&&input[left+1]>input[left]?left+1:left;
            largest = input[largest]>input[index]?largest:index;
            if(largest==index){
                break;
            }
            swap(input,largest,index);
            index = largest;
            left = largest*2+1;
        }
    }

    private static void heapInsert(int[] input, int index) {
        while (input[index]>input[(index-1)/2]){
            swap(input,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    private static void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution02(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int length = input.length;
        if(k>length||k==0||input==null){
            return list;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length ; i++){
            if(maxHeap.size()!=k){
                maxHeap.offer(input[i]);
            }else if(maxHeap.peek()>input[i]){
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for(Integer in:maxHeap){
            list.add(in);
        }
        return list;
    }
}
