package main.com.lwq.demo;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: Lwq
 * @Date: 2018/8/31 9:54
 * @Version 1.0
 * @Describe  从尾到头打印链表
 */
public class Demo01 {
    //利用栈
    public static ArrayList<Integer> printListFromTailToHead01(ListNode node){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        ListNode t = node;
        while (t!=null){
            stack.push(t.value);
            t = t.next;
        }
        while (stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    //利用递归
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead02(ListNode node){
        if(node!=null){
            this.printListFromTailToHead02(node.next);
            list.add(node.value);
        }
        return list;
    }

    class ListNode{
        int value;
        ListNode next;
    }
}
