package main.com.lwq.offer66;

/**
 * @Author: Lwq
 * @Date: 2018/10/13 11:15
 * @Version 1.0
 * @Describe
 */
/*
操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Solution18 {
    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left!=null){
            Mirror(root.left);
        }
        if(root.right!=null){
            Mirror(root.right);
        }
    }
}
