package main.com.lwq.demo;

import sun.nio.cs.ext.MacArabic;

/**
 * @Author: Lwq
 * @Date: 2018/9/19 16:25
 * @Version 1.0
 * @Describe
 */
/*
判断一个树是不是平衡二叉树
 */
public class IsBalancedTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(process(head).isB);
    }

    public static class ReturnData{
        private boolean isB;
        private int h;
        public ReturnData(boolean isB,int h){
            this.isB = isB;
            this.h = h;
        }
    }

    public static ReturnData process(Node head){
        if(head==null){
            return new ReturnData(true,0);
        }
        ReturnData leftData = process(head.left);
        if(!leftData.isB){
            return new ReturnData(false,0);
        }
        ReturnData rightData = process(head.right);
        if(!rightData.isB){
            return new ReturnData(false,0);
        }
        if(Math.abs(leftData.h-rightData.h)>1){
            return new ReturnData(false,0);
        }
        return new ReturnData(true,Math.max(leftData.h,rightData.h)+1);
    }
}
