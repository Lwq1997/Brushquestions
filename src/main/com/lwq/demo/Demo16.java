package main.com.lwq.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/11 17:33
 * @Version 1.0
 * @Describe
 */
    /*
    样例输入
5 24 39 60 15 28 27 40 50 90
样例输出
(5, 24) (27, 40) (50, 90)
     */
public class Demo16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = null;
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        nums = sc.nextLine().split(" ");
        int length = nums.length;
        int num[]=new int[length];
        for(int i=0;i<length;i++) {
            num[i] = Integer.valueOf(nums[i]);
        }
        int num2[] = new int[length];
        System.arraycopy(num,0,num2,0,length);
        Arrays.sort(num2);
        for(int i = 0; i < length;i++){
            if(num2[i]>max(list)){
                list.add(num2[i]);
                Integer next = find(num2[i],num);
                if(next!=null){
                    list.add(next);
                }
            }
        }
        for(int i = 0;i<list.size();i+=2){
            if(i+1<list.size()){
                sb.append("("+list.get(i)+", "+list.get(i+1)+")"+" ");
            }
        }
        System.out.println(sb.toString());
    }

    private static Integer find(int i,int[] num) {
        for(int j  = 0; j < num.length;j++){
            if(j%2==0&&num[j]==i&&j+1<num.length){
                return num[j+1];
            }
        }
        return null;
    }

    private static int max(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size();i++){
            max = Math.max(max,list.get(i));
        }
        return max;
    }
}
