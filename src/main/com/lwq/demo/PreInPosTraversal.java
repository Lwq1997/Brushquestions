package main.com.lwq.demo;

import java.util.Stack;

/**
 * @Author: Lwq
 * @Date: 2018/9/19 15:04
 * @Version 1.0
 * @Describe
 */
public class PreInPosTraversal {
    public static class Node{
        public  int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
    }


    private static void posOrderUnRecur1(Node head) {
        System.out.print("pos-order: ");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            Stack<Node> help = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                help.push(head);
                if(head.left != null){
                    stack.push(head.left);
                }
                if(head.right !=null){
                    stack.push(head.right);
                }
            }
            while (!help.isEmpty()){
                System.out.print(help.pop().value+" ");
            }
        }
        System.out.println();
    }

    /*
    非递归的中序遍历,就是每次把左子树的一列压入栈中
     */
    private static void inOrderUnRecur(Node head) {
        System.out.print("int-order: ");
        if(head!=null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty()||head!=null){
                if(head!=null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head.value+" ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /*
    非递归的前序遍历，就是按中右左的顺序把节点压栈
     */
    public static void preOrderUnRecur(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    private static void posOrderRecur(Node head) {
        if(head==null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value+" ");
    }

    private static void inOrderRecur(Node head) {
        if(head==null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value+" ");
        inOrderRecur(head.right);
    }

    private static void preOrderRecur(Node head) {
        if(head==null){
            return;
        }
        System.out.print(head.value+" ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
}
