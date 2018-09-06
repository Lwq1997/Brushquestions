package main.com.lwq.wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Lwq
 * @Date: 2018/9/4 16:06
 * @Version 1.0
 * @Describe
 */
/*
小易老师是非常严厉的,它会要求所有学生在进入教室前都排成一列,并且他要求学生按照身高不递减的顺序排列。
有一次,n个学生在列队的时候,小易老师正好去卫生间了。学生们终于有机会反击了,于是学生们决定来一次疯狂的队列,
他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。由于按照身高顺序排列的队列的疯狂值是最小的,
他们当然决定按照疯狂值最大的顺序来进行列队。现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值。
小易老师回来一定会气得半死。

输入描述:
输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),表示学生的人数
第二行为n个整数h[i](1 ≤ h[i] ≤ 1000),表示每个学生的身高

输出描述:
输出一个整数,表示n个学生列队可以获得的最大的疯狂值。

如样例所示:
当队列排列顺序是: 25-10-40-5-25, 身高差绝对值的总和为15+30+35+20=100。
这是最大的疯狂值了。

输入例子1:
5
5 10 25 40 25

输出例子1:
100
 */
/*
将原数列排好序，每次取数列中的最大与最小值加入到疯狂队列中
 */
public class Question23 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            int n = sc.nextInt();
//            int[] nums = new int[n];
//            for(int i=0; i < n;i++){
//                nums[i] = sc.nextInt();
//            }
//            Arrays.sort(nums);
//            int min = nums[0];
//            int max = nums[n-1];
//            int diff = max-min;
//            int minIndex = 1;
//            int maxIndex = n-2;
//            while (minIndex<maxIndex){
//                diff+=max-nums[minIndex];
//                diff+=nums[maxIndex]-min;
//                min = nums[minIndex++];
//                max = nums[maxIndex--];
//            }
//            // 原数列中最后一个数 minIndex == maxIndex，将它放到合适的位置上
//            diff+=Math.max(nums[maxIndex]-min,max-nums[minIndex]);
//            System.out.println(diff);
//        }
//    }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()){
                int n = sc.nextInt();
                int[] nums = new int[n];
                List<Integer> list = new ArrayList();
                for(int i=0; i < n;i++){
                    nums[i] = sc.nextInt();
                }
                Arrays.sort(nums);
                for(int i = 0; i<n/2;i++){
                    list.add(nums[i]);
                    list.add(nums[n-i-1]);
                }
                if(n%2==1){
                    list.add(nums[n/2]);
                }
                int sum = 0;
                for(int i = 0 ; i < list.size()-2;i++){
                    sum += Math.abs(list.get(i+1)-list.get(i));
                }
                if(Math.abs(list.get(n-1)-list.get(0))>Math.abs(list.get(n-1)-list.get(n-2))){
                    sum+=Math.abs(list.get(n-1)-list.get(0));
                }else {
                    sum+=Math.abs(list.get(n-1)-list.get(n-2));
                }
                System.out.println(sum);
            }
        }
}
