package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/17 12:04
 * @Version 1.0
 * @Describe
 */

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Solution36 {
    /**
     * 找出2个链表的长度，然后让长的先走两个链表的长度差，
     * 然后再一起走
     * （因为2个链表用公共的尾部）
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = findListLength(pHead1);
        int len2 = findListLength(pHead2);
        if(len1>len2){
            pHead1 = walkStep(pHead1,len1-len2);
        }else {
            pHead2 = walkStep(pHead2,len2-len1);
        }
        while (pHead1!=null){
            if(pHead1==pHead2){
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    private ListNode walkStep(ListNode pHead, int step) {
        while (step>0){
            pHead = pHead.next;
            step--;
        }
        return pHead;
    }

    private int findListLength(ListNode pHead1) {
        if(pHead1==null){
            return 0;
        }
        int count = 0;
        while (pHead1!=null){
            count++;
            pHead1 = pHead1.next;
        }
        return count;
    }
}
