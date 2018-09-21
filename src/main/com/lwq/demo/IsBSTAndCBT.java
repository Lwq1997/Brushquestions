package main.com.lwq.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: Lwq
 * @Date: 2018/9/19 16:47
 * @Version 1.0
 * @Describe
 */
/*
判断是不是二叉搜索数和完全二叉树
 */
public class IsBSTAndCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        System.out.println(isBST(head));
        System.out.println(isCBT(head));

    }

    //按层遍历
    private static boolean isCBT(Node head) {
        if(head==null){
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l  = null;
        Node r  = null;
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            //左孩子是null，右孩子不是null，false
            //leaf如果是true了，那么接下来的所有节点都必须是叶节点
            if((leaf && (l!=null || r!=null)) || (l == null && r!=null)){
                return false;
            }
            if(l != null){
                queue.offer(l);
            }
            if(r != null){
                queue.offer(r);
            }
            if(l==null||r==null){
                leaf = true;
            }
        }
        return true;
    }

    //中序遍历后看是不是递增的
    private static boolean isBST(Node head) {
        int pre = Integer.MIN_VALUE;
        boolean flag =true;
        if(head!=null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty()||head!=null){
                if(head!=null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    if(head.value<pre){
                        flag = false;
                    }
                    pre = head.value;
                    head = head.right;
                }
            }
        }
        return flag;
    }

}
