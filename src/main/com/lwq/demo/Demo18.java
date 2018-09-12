package main.com.lwq.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Lwq
 * @Date: 2018/9/12 10:15
 * @Version 1.0
 * @Describe
 */
/*
双栈排序
 */
public class Demo18 {
    public static void main(String[] args) {
        int[] numbers = new int[]{2,5,9,3,1,4,7,8,5};
        List<Integer> list = twoStackSort(numbers);
        for(int i:list){
            System.out.print(i+" ");
        }
    }

    private static List<Integer> twoStackSort(int[] numbers) {
        ArrayList<Integer> result = new ArrayList<>(numbers.length);
        //初始化栈
        Stack<Integer> stack = new Stack<>();
        int index = numbers.length-1;
        for(int i = index;i>-1;i--){
            stack.push(numbers[i]);
        }
        //辅助栈
        Stack<Integer> resultStack = new Stack<>();
        while (!stack.empty()){
            if(resultStack.empty()){
                resultStack.push(stack.pop());
            }else {
                int a = stack.pop();
                int b = resultStack.pop();
                if(a<b){
                    stack.push(b);
                    while (!resultStack.empty()&&a<(b=resultStack.pop())){
                        stack.push(b);
                    }
                }
                if(a>b){
                    resultStack.push(b);
                }
                resultStack.push(a);
            }
        }
        while (!resultStack.empty()){
            result.add(resultStack.pop());
        }
        return result;
    }
}
