package main.com.lwq.offer66;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Lwq
 * @Date: 2018/10/13 12:22
 * @Version 1.0
 * @Describe
 */
/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();

        deque.add(root);
        while (deque.size()!=0){
            TreeNode treeNode = deque.pop();
            list.add(treeNode.val);
            if(treeNode.left!=null){
                deque.add(treeNode.left);
            }
            if(treeNode.right!=null){
                deque.add(treeNode.right);
            }
        }
        return list;
    }
}
