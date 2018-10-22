package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/11 21:29
 * @Version 1.0
 * @Describe
 */
/*
输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode slow = head;
        ListNode fast = head;
        if(head==null||k==0){
            return null;
        }
        for(int i = 1; i< k ;i++){
            if(fast.next!=null){
                fast = fast.next;
            }else {
                return null;
            }
        }
        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}