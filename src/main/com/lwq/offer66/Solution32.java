package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/16 17:05
 * @Version 1.0
 * @Describe
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution32 {
    public static void main(String[] args) {
        System.out.println(PrintMinNumber(new int[]{3,5,1,4,2}));
    }
    public static String PrintMinNumber(int [] numbers) {

        Integer[] num = new Integer[numbers.length];
        for(int i = 0; i < numbers.length ; i++){
            num[i] = numbers[i];
        }
        StringBuilder s = new StringBuilder();
        Comparator<Integer> comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1 = String.valueOf(o1)+String.valueOf(o2);
                String s2 = String.valueOf(o2)+String.valueOf(o1);
                return s1.compareTo(s2);
            }
        };
        Arrays.sort(num,comparator);
        for(int i = 0; i < numbers.length ; i++){
            s.append(String.valueOf(num[i]));
        }
        return s.toString();
    }

    public static String PrintMinNumber02(int [] numbers) {
        StringBuilder s = new StringBuilder();
        ArrayList<Integer> list= new ArrayList<Integer>();
        int n=numbers.length;
        for(int i=0;i<n;i++){
            list.add(numbers[i]);
        }
        Comparator<Integer> comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1 = String.valueOf(o1)+String.valueOf(o2);
                String s2 = String.valueOf(o2)+String.valueOf(o1);
                return s1.compareTo(s2);
            }
        };
        Collections.sort(list, comparator);
        for(int i:list){
            s.append(String.valueOf(i));
        }
        return s.toString();
    }
}
