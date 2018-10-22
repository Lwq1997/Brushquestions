package main.com.lwq.offer66;

import java.util.HashMap;

/**
 * @Author: Lwq
 * @Date: 2018/10/13 13:41
 * @Version 1.0
 * @Describe
 */
/*
输入一个复杂链表（每个节点中有节点值，以及两个指针，
一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。
（注意，输出结果中请不要返回参数中的节点引用，
否则判题程序会直接返回空）
 */
public class Solution25 {
    public RandomListNode Clone(RandomListNode pHead){
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        while (cur!=null){
            map.put(cur,new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = pHead;
        while (cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }
    public RandomListNode Clone02(RandomListNode pHead){
        if(pHead==null){
            return null;
        }
        RandomListNode cur = pHead;
        RandomListNode next = null;
        //复制每个节点的next节点
        while (cur!=null){
            next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
        //设置复制节点的rand
        cur = pHead;
        RandomListNode curCopy = null;
        while (cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random!=null?cur.random.next:null;
            cur = next;
        }
        //分开
        RandomListNode res = pHead.next;
        cur = pHead;
        while (cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next!=null?next.next:null;
            cur=next;
        }
        return res;
    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}