package main.com.lwq.offer66;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lwq
 * @Date: 2018/10/11 15:27
 * @Version 1.0
 * @Describe
 */
/*
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Solution03 {
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode pre = new ListNode(-1);
        pre.next = head;
        for(int i =1 ; i < 10;i++){
            head.next=new ListNode(i);
            head = head.next;
        }
        List<Integer> res = printListFromTailToHead(pre);
        for(int i = 0; i < res.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode.next!=null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


