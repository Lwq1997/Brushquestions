package main.com.lwq.demo;

/**
 * @Author: Lwq
 * @Date: 2018/9/11 15:16
 * @Version 1.0
 * @Describe
 */
/*
单链表的翻转
 */
public class Demo14 {
    static class Node{
        private int Data;
        private Node Next;
        public Node(int Data){
            this.Data = Data;
        }

        public int getData() {
            return Data;
        }

        public void setData(int data) {
            Data = data;
        }

        public Node getNext() {
            return Next;
        }

        public void setNext(Node next) {
            Next = next;
        }
    }

    //递归翻转法
    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        // 调用反转方法
//        head = Reverse1(head);
        head = Reverse2(head);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != head) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }

    private static Node Reverse1(Node head) {
        if(head==null||head.getNext()==null){
            return head;
        }
        Node reHead = Reverse1(head.getNext());// 先反转后续节点head.getNext()
        head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
        head.setNext(null);// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }

    private static Node Reverse2(Node head) {
        if(head==null||head.getNext()==null){
            return head;
        }
        Node pre = head;// 上一结点
        Node cur = head.getNext();// 当前结点
        Node tmp ;// 临时结点，用于保存当前结点的指针域（即下一结点）
        while (cur!=null){
            tmp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = tmp;
        }
        head.setNext(null);
        return pre;
    }

}
