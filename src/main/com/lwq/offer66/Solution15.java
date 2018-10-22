package main.com.lwq.offer66;


/**
 * @Author: Lwq
 * @Date: 2018/10/11 21:36
 * @Version 1.0
 * @Describe
 */
/*
输入一个链表，反转链表后，输出新链表。
 */
public class Solution15 {
    public ListNode ReverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode pHead = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return pHead;
    }

    public ListNode ReverseList2(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre = head;// 上一结点
        ListNode cur = head.next;// 当前结点
        ListNode tmp ;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur!=null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head.next = null;
        return pre;
    }
}
