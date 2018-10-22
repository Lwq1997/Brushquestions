package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/19 12:17
 * @Version 1.0
 * @Describe
 */

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，
 * 链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution56 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        ListNode newNode = deleteDuplication(node);
    }
    public static ListNode deleteDuplication(ListNode pHead) {
        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode p = pHead;
        ListNode last = first;
        while (p!=null&&p.next!=null){
            if(p.val == p.next.val){
                int val = p.val;
                while (p!=null && p.val == val){
                    p = p.next;
                }
                last.next = p;
            }else {
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }
}
